/**
 * LeetCode 3034 - Number of Subarrays That Match a Pattern I
 * 
 * Link: https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/
 * 
 * Problem Description:
 * You are given a 0-indexed integer array nums of length n, and a 0-indexed integer
 * array pattern of length m consisting of integers -1, 0, and 1.
 * 
 * A subarray nums[i..j] of length m + 1 is said to match the pattern if the following
 * conditions hold for each element pattern[k]:
 * - nums[i + k + 1] > nums[i + k] if pattern[k] == 1
 * - nums[i + k + 1] == nums[i + k] if pattern[k] == 0
 * - nums[i + k + 1] < nums[i + k] if pattern[k] == -1
 * 
 * Return the count of subarrays in nums that match the pattern.
 * 
 * Solution Approach:
 * For each possible subarray start:
 * 1. Extract a subarray of length pattern.length + 1
 * 2. Compare each consecutive pair in subarray with corresponding pattern
 * 3. Convert relationship between consecutive numbers to -1, 0, or 1
 * 4. If all comparisons match, increment counter
 * 
 * Time Complexity: O(n * m) where n is array length, m is pattern length
 * Space Complexity: O(1)
 */
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        int n = nums.length;
        int m = pattern.length;
        
        for (int i = 0; i <= n - m - 1; i++) {
            boolean matches = true;
            for (int j = 0; j < m; j++) {
                int expected = pattern[j];
                int actual;
                
                if (nums[i + j + 1] > nums[i + j]) {
                    actual = 1;
                } else if (nums[i + j + 1] == nums[i + j]) {
                    actual = 0;
                } else {
                    actual = -1;
                }
                
                if (actual != expected) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                count++;
            }
        }
        
        return count;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3034 - Number of Subarrays That Match Pattern I ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] pattern1 = {1, 1};
        int result1 = sol.countMatchingSubarrays(nums1, pattern1);
        assert result1 == 4 : "Test 1 failed: expected 4, got " + result1;
        System.out.println("✓ Test 1 passed: expected 4, got " + result1);
        
        // Test 2: Patrón con decremento
        int[] nums2 = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern2 = {1, 0, -1};
        int result2 = sol.countMatchingSubarrays(nums2, pattern2);
        assert result2 == 2 : "Test 2 failed: expected 2, got " + result2;
        System.out.println("✓ Test 2 passed: expected 2, got " + result2);
        
        // Test 3: Sin coincidencias
        int[] nums3 = {1, 2, 3};
        int[] pattern3 = {1, 1};
        int result3 = sol.countMatchingSubarrays(nums3, pattern3);
        assert result3 == 1 : "Test 3 failed: expected 1, got " + result3;
        System.out.println("✓ Test 3 passed: expected 1, got " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

