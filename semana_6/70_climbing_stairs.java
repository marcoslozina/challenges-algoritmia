/**
 * LeetCode 70 - Climbing Stairs
 * 
 * Link: https://leetcode.com/problems/climbing-stairs/
 * 
 * Problem Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top: 1 step + 1 step + 1 step, 1 step + 2 steps, 2 steps + 1 step
 * 
 * Solution Approach:
 * This is essentially the Fibonacci problem:
 * - To reach step n, you can come from step n-1 or n-2
 * - dp[n] = dp[n-1] + dp[n-2]
 * - Base cases: dp[1] = 1, dp[2] = 2
 * 
 * Optimization: We only need the two previous values, so we use variables instead of an array for O(1) space.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1; // dp[1]
        int prev1 = 2; // dp[2]
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 70 - Climbing Stairs ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        assert sol.climbStairs(2) == 2 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: n=2 -> 2 formas");
        
        // Test 2: Caso más grande
        assert sol.climbStairs(3) == 3 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: n=3 -> 3 formas");
        
        // Test 3: n=5
        assert sol.climbStairs(5) == 8 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: n=5 -> 8 formas");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

