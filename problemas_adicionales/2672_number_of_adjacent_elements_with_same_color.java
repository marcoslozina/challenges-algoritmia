import java.util.Arrays;

/**
 * LeetCode 2672 - Number of Adjacent Elements With the Same Color
 * 
 * Link: https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/
 * 
 * Problem Description:
 * There is a 0-indexed array nums of length n. Initially, all elements are uncolored
 * (has a value of 0).
 * 
 * You are given a 2D integer array queries where queries[i] = [indexi, colori].
 * 
 * For each query, you are allowed to do the following operation on the array:
 * - Color the index indexi with the color colori.
 * 
 * Return an array answer of the same length as queries where answer[i] is the number
 * of adjacent elements with the same color after the ith query.
 * 
 * More formally, answer[i] is the number of indices j, such that 0 <= j < n - 1 and
 * nums[j] == nums[j + 1] and nums[j] != 0 after the ith query.
 * 
 * Solution Approach:
 * We maintain a counter of adjacent pairs with the same color:
 * 1. For each query, first remove contributions from previous color:
 *    - If left element had same color, decrement
 *    - If right element had same color, decrement
 * 2. Update color at index
 * 3. Add new contributions:
 *    - If left element has same color, increment
 *    - If right element has same color, increment
 * 4. Return current counter
 * 
 * Time Complexity: O(n) where n is the number of queries
 * Space Complexity: O(n)
 */
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];
        int[] result = new int[queries.length];
        int count = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            
            // Remove old contributions
            if (index > 0 && nums[index] != 0 && nums[index] == nums[index - 1]) {
                count--;
            }
            if (index < n - 1 && nums[index] != 0 && nums[index] == nums[index + 1]) {
                count--;
            }
            
            // Update color
            nums[index] = color;
            
            // Add new contributions
            if (index > 0 && nums[index] == nums[index - 1]) {
                count++;
            }
            if (index < n - 1 && nums[index] == nums[index + 1]) {
                count++;
            }
            
            result[i] = count;
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 2672 - Number of Adjacent Elements With Same Color ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int n1 = 4;
        int[][] queries1 = {{0, 2}, {1, 2}, {3, 1}};
        int[] result1 = sol.colorTheArray(n1, queries1);
        // After query 0: [2,0,0,0] -> 0 pairs
        // After query 1: [2,2,0,0] -> 1 pair (indices 0-1)
        // After query 2: [2,2,0,1] -> 1 pair (still 0-1)
        assert result1[0] == 0 : "Test 1.1 failed: expected 0, got " + result1[0];
        assert result1[1] == 1 : "Test 1.2 failed: expected 1, got " + result1[1];
        assert result1[2] == 1 : "Test 1.3 failed: expected 1, got " + result1[2];
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Múltiples colores iguales
        int n2 = 1;
        int[][] queries2 = {{0, 1}, {0, 1}};
        int[] result2 = sol.colorTheArray(n2, queries2);
        assert result2[0] == 0 : "Test 2.1 failed";
        assert result2[1] == 0 : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: " + Arrays.toString(result2));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

