import java.util.*;

/**
 * LeetCode 739 - Daily Temperatures
 * 
 * Link: https://leetcode.com/problems/daily-temperatures/
 * 
 * Problem Description:
 * Given an array of integers temperatures represents the daily temperatures, return an array
 * answer such that answer[i] is the number of days you have to wait after the ith day to get
 * a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0.
 * 
 * Example:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * Solution Approach:
 * We use a monotonic decreasing stack:
 * 1. Maintain a stack with day indices
 * 2. For each day, while current temperature is greater than stack top:
 *    - Calculate day difference (current index - stack top index)
 *    - Update answer[stack top index] with the difference
 *    - Remove index from stack
 * 3. Add current index to stack
 * 
 * Time Complexity: O(n) - each index is added and removed at most once
 * Space Complexity: O(n)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return answer;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 739 - Daily Temperatures ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = sol.dailyTemperatures(temps1);
        int[] expected1 = {1, 1, 4, 2, 1, 1, 0, 0};
        assert Arrays.equals(result1, expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Temperaturas decrecientes
        int[] temps2 = {30, 40, 50, 60};
        int[] result2 = sol.dailyTemperatures(temps2);
        int[] expected2 = {1, 1, 1, 0};
        assert Arrays.equals(result2, expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

