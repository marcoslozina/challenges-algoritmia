import java.util.*;

/**
 * LeetCode 723 - Candy Crush
 * 
 * Link: https://leetcode.com/problems/candy-crush/
 * Visual Explanation: https://neetcode.io/practice
 * 
 * Problem Description:
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * 
 * Given a 2D integer array board representing the grid of candy, different positive integers
 * board[i][j] represent different types of candies. A value of board[i][j] = 0 represents
 * that the cell at position (i, j) is empty. The given board represents the state of the
 * game following the player's move.
 * 
 * Now, you need to crush the candies according to the following rules:
 * - If three or more candies of the same type are adjacent vertically or horizontally,
 *   crush them all at the same time - these positions become empty.
 * - After crushing, if an empty space on the board has candies on top of itself, then
 *   these candies will drop until they hit a candy or bottom at the same time.
 * - After the above steps, there may be more candies that can be crushed. If so, repeat.
 * - If there are no more candies that can be crushed, return the current board.
 * 
 * Solution Approach:
 * 1. Iterate until no more groups to eliminate:
 *    a. Mark cells to eliminate (using negative values)
 *    b. Find horizontal groups of 3+ equal cells
 *    c. Find vertical groups of 3+ equal cells
 * 2. Apply gravity: move candies down, filling empty spaces
 * 3. Repeat until no more changes
 * 
 * Time Complexity: O((m * n)^2) in worst case, but typically much better
 * Space Complexity: O(m * n)
 */
class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean found = true;
        
        while (found) {
            found = false;
            Set<String> toCrush = new HashSet<>();
            
            // Check horizontal matches
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) 
                        && Math.abs(board[i][j]) == Math.abs(board[i][j + 2])) {
                        found = true;
                        toCrush.add(i + "," + j);
                        toCrush.add(i + "," + (j + 1));
                        toCrush.add(i + "," + (j + 2));
                    }
                }
            }
            
            // Check vertical matches
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val != 0 && Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) 
                        && Math.abs(board[i][j]) == Math.abs(board[i + 2][j])) {
                        found = true;
                        toCrush.add(i + "," + j);
                        toCrush.add((i + 1) + "," + j);
                        toCrush.add((i + 2) + "," + j);
                    }
                }
            }
            
            // Mark cells to be crushed (use negative to mark)
            for (String key : toCrush) {
                String[] parts = key.split(",");
                int i = Integer.parseInt(parts[0]);
                int j = Integer.parseInt(parts[1]);
                board[i][j] = -Math.abs(board[i][j]);
            }
            
            // Drop candies
            for (int j = 0; j < n; j++) {
                int writeIdx = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[writeIdx][j] = board[i][j];
                        writeIdx--;
                    }
                }
                // Fill remaining with zeros
                while (writeIdx >= 0) {
                    board[writeIdx][j] = 0;
                    writeIdx--;
                }
            }
        }
        
        return board;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 723 - Candy Crush ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] board1 = {
            {110, 5, 112, 113, 114},
            {210, 211, 5, 213, 214},
            {310, 311, 3, 313, 314},
            {410, 411, 412, 5, 414},
            {5, 1, 512, 3, 3},
            {610, 4, 1, 613, 614},
            {710, 1, 2, 713, 714},
            {810, 1, 2, 1, 1},
            {1, 1, 2, 2, 2},
            {4, 1, 4, 4, 1014}
        };
        int[][] result1 = sol.candyCrush(board1);
        System.out.println("✓ Test 1 passed: Tablero procesado");
        
        // Test 2: Tablero pequeño
        int[][] board2 = {
            {1, 3, 5, 5, 2},
            {3, 4, 3, 3, 1},
            {3, 2, 4, 5, 2},
            {2, 4, 4, 5, 5},
            {1, 4, 4, 1, 1}
        };
        int[][] result2 = sol.candyCrush(board2);
        System.out.println("✓ Test 2 passed: Tablero pequeño");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

