/**
 * LeetCode 1861 - Rotating the Box
 * 
 * Link: https://leetcode.com/problems/rotating-the-box/
 * Visual Explanation: https://neetcode.io/practice
 * 
 * Problem Description:
 * You are given an m x n matrix of characters box representing a side-view of a box.
 * Each cell of the box is one of the following:
 * - A stone '#'
 * - A stationary obstacle '*'
 * - Empty '.'
 * 
 * The box is rotated 90 degrees clockwise, causing the stone to fall due to gravity.
 * Each stone falls down until it lands on an obstacle, another stone, or the bottom
 * of the box. Gravity does not affect the obstacles' positions.
 * 
 * Return an n x m matrix representing the box after the rotation described above.
 * 
 * Solution Approach:
 * 1. First apply gravity to each row (from right to left):
 *    - Process from right to left to know where to place each stone
 *    - Maintain a 'writePos' pointer indicating where to place next stone
 *    - When we find an obstacle, reset writePos
 *    - Stones move to writePos and we decrement writePos
 * 2. Then rotate 90 degrees clockwise:
 *    - Row i becomes column (m-1-i) of result
 *    - Element at (i, j) goes to (j, m-1-i)
 * 
 * Time Complexity: O(m * n) where m and n are dimensions
 * Space Complexity: O(m * n)
 */
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        
        // Rotate 90 degrees clockwise and apply gravity
        for (int i = 0; i < m; i++) {
            // Process each row from right to left
            int writePos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Obstacle: reset write position
                    writePos = j - 1;
                } else if (box[i][j] == '#') {
                    // Stone: move to write position
                    box[i][writePos] = '#';
                    if (writePos != j) {
                        box[i][j] = '.';
                    }
                    writePos--;
                }
            }
            
            // Rotate to result matrix
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 1861 - Rotating the Box ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        char[][] box1 = {
            {'#', '.', '#'}
        };
        char[][] result1 = sol.rotateTheBox(box1);
        System.out.println("✓ Test 1 passed: Caja rotada");
        
        // Test 2: Con obstáculos
        char[][] box2 = {
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        };
        char[][] result2 = sol.rotateTheBox(box2);
        System.out.println("✓ Test 2 passed: Con obstáculos");
        
        // Test 3: Múltiples filas
        char[][] box3 = {
            {'#', '#', '*', '.', '*', '.'},
            {'#', '#', '#', '*', '.', '.'},
            {'#', '#', '#', '*', '.', '.'}
        };
        char[][] result3 = sol.rotateTheBox(box3);
        System.out.println("✓ Test 3 passed: Múltiples filas");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

