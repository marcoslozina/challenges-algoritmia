/**
 * LeetCode 198 - House Robber
 * 
 * Link: https://leetcode.com/problems/house-robber/
 * Visual Explanation: https://neetcode.io/practice/house-robber
 * Video Solution: https://www.youtube.com/watch?v=73r3KWiEvyk
 * 
 * Problem Description:
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 * 
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.
 * 
 * Solution Approach:
 * 1D DP:
 * - dp[i] = maximum money we can rob up to house i
 * - For each house, we have two options:
 *   1. Rob this house: nums[i] + dp[i-2]
 *   2. Don't rob this house: dp[i-1]
 * - dp[i] = max(dp[i-1], nums[i] + dp[i-2])
 * 
 * Optimization: We only need the two previous values.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = 0; // dp[i-2]
        int prev1 = nums[0]; // dp[i-1]
        
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 198 - House Robber ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 2, 3, 1};
        int result1 = sol.rob(nums1);
        assert result1 == 4 : "Test 1 failed: expected 4, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Dos casas
        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = sol.rob(nums2);
        assert result2 == 12 : "Test 2 failed: expected 12, got " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Una casa
        int[] nums3 = {2};
        int result3 = sol.rob(nums3);
        assert result3 == 2 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

