import java.util.*;

/**
 * LeetCode 322 - Coin Change
 * 
 * Link: https://leetcode.com/problems/coin-change/
 * Visual Explanation: https://neetcode.io/practice/coin-change
 * Video Solution: https://www.youtube.com/watch?v=H9bfqozjoqs
 * 
 * Problem Description:
 * You are given an integer array coins representing coins of different denominations and an
 * integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Solution Approach:
 * DP with tabulation:
 * - dp[i] = minimum number of coins to make amount i
 * - For each amount i, try each coin:
 *   - If coin <= i: dp[i] = min(dp[i], 1 + dp[i - coin])
 * - Initialize dp[0] = 0, rest with a large value
 * 
 * Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Valor mayor que cualquier solución posible
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 322 - Coin Change ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int result1 = sol.coinChange(coins1, amount1);
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1 + " monedas");
        
        // Test 2: Imposible
        int[] coins2 = {2};
        int amount2 = 3;
        int result2 = sol.coinChange(coins2, amount2);
        assert result2 == -1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Imposible");
        
        // Test 3: Monto cero
        int[] coins3 = {1};
        int amount3 = 0;
        int result3 = sol.coinChange(coins3, amount3);
        assert result3 == 0 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

