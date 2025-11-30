import java.util.*;

/**
 * LeetCode 2768 - Number of Black Blocks
 * 
 * Link: https://leetcode.com/problems/number-of-black-blocks/
 * Visual Explanation: https://neetcode.io/practice
 * 
 * Problem Description:
 * You are given two integers m and n representing the dimensions of a floor plan of a
 * room. The floor plan is an m x n grid where each cell is either black (1) or white (0).
 * 
 * You are also given an array coordinates where coordinates[i] = [x, y] represents a
 * black cell with coordinates (x, y) from the top-left cell (which has coordinates [0, 0]).
 * 
 * Every day, an infinite number of blocks are placed on the floor. Each block has size
 * 2 x 2 and covers exactly 4 cells of the floor. Blocks can only be placed on white cells,
 * and blocks cannot overlap.
 * 
 * Return an array result of length 5 where result[j] is the number of ways to place j blocks
 * on the floor such that no two blocks overlap and no block covers any black cell.
 * 
 * Solution Approach:
 * 1. For each black cell, identify which 2x2 blocks it belongs to
 *    (a cell can be part of up to 4 different blocks)
 * 2. Use a HashMap to count how many black cells each 2x2 block has
 * 3. Group blocks by number of black cells (0-4)
 * 4. Number of blocks with 0 black cells = total blocks - blocks with black cells
 * 
 * Time Complexity: O(m + n) where m is number of coordinates, n is grid size
 * Space Complexity: O(m)
 */
class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<String, Integer> blockCount = new HashMap<>();
        
        // For each black cell, mark which 2x2 blocks it belongs to
        for (int[] coord : coordinates) {
            int r = coord[0];
            int c = coord[1];
            
            // A cell can be part of up to 4 different 2x2 blocks
            for (int dr = 0; dr >= -1; dr--) {
                for (int dc = 0; dc >= -1; dc--) {
                    int topR = r + dr;
                    int topC = c + dc;
                    if (topR >= 0 && topR < m - 1 && topC >= 0 && topC < n - 1) {
                        String key = topR + "," + topC;
                        blockCount.put(key, blockCount.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        
        // Count blocks by number of black cells
        long[] result = new long[5];
        for (int count : blockCount.values()) {
            if (count <= 4) {
                result[count]++;
            }
        }
        
        // Total number of 2x2 blocks
        long totalBlocks = (long)(m - 1) * (n - 1);
        result[0] = totalBlocks - (result[1] + result[2] + result[3] + result[4]);
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 2768 - Number of Black Blocks ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] coords1 = {{0, 0}, {1, 1}, {0, 2}};
        long[] result1 = sol.countBlackBlocks(3, 3, coords1);
        assert result1.length == 5 : "Test 1.1 failed";
        System.out.println("Resultado Test 1: " + Arrays.toString(result1));
        System.out.println("✓ Test 1 passed");
        
        // Test 2: Sin celdas negras
        int[][] coords2 = {};
        long[] result2 = sol.countBlackBlocks(2, 2, coords2);
        assert result2[0] == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Sin celdas negras");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

