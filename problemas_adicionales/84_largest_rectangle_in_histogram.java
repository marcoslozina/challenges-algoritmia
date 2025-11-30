import java.util.*;

/**
 * LeetCode 84 - Largest Rectangle in Histogram
 * 
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Problem Description:
 * Given an array of integers heights representing the histogram's bar height where the
 * width of each bar is 1, return the area of the largest rectangle in the histogram.
 * 
 * Example:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The largest rectangle is formed by bars with heights [5,6], area = 5*2 = 10
 * 
 * Solution Approach:
 * We use a monotonic stack to maintain bar indices in increasing order:
 * 1. For each bar, while current bar is smaller than stack top:
 *    a. Calculate area of rectangle formed by stack top bar
 *    b. Width extends from previous index in stack to current index
 * 2. Add a 0 at the end to process all remaining bars
 * 3. Maintain the maximum area found
 * 
 * Key insight: When we find a lower bar, we know that higher bars in the stack
 * cannot extend further to the right.
 * 
 * Time Complexity: O(n) where n is the number of bars
 * Space Complexity: O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 84 - Largest Rectangle in Histogram ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int result1 = sol.largestRectangleArea(heights1);
        assert result1 == 10 : "Test 1 failed: expected 10, got " + result1;
        System.out.println("✓ Test 1 passed: expected 10, got " + result1);
        
        // Test 2: Alturas crecientes
        int[] heights2 = {2, 4};
        int result2 = sol.largestRectangleArea(heights2);
        assert result2 == 4 : "Test 2 failed: expected 4, got " + result2;
        System.out.println("✓ Test 2 passed: expected 4, got " + result2);
        
        // Test 3: Una barra
        int[] heights3 = {1};
        int result3 = sol.largestRectangleArea(heights3);
        assert result3 == 1 : "Test 3 failed: expected 1, got " + result3;
        System.out.println("✓ Test 3 passed: expected 1, got " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

