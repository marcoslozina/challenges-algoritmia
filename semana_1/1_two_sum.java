import java.util.*;

/**
 * LeetCode 1 - Two Sum
 * 
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * Problem Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly one solution,
 * and you may not use the same element twice. You can return the answer in any order.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Solution Approach:
 * Use a HashMap to store each number and its index as we iterate.
 * For each number, check if (target - current number) exists in the map.
 * If found, return the indices.
 * 
 * Time Complexity: O(n) where n is the length of nums
 * Space Complexity: O(n) for the HashMap
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 1 - Two Sum ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = sol.twoSum(nums1, target1);
        assert result1.length == 2 : "Test 1.1 failed";
        assert (nums1[result1[0]] + nums1[result1[1]] == target1) : "Test 1.2 failed";
        System.out.println("✓ Test 1 passed: nums=[2,7,11,15], target=9 -> " + 
                         java.util.Arrays.toString(result1));
        
        // Test 2: Números negativos
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = sol.twoSum(nums2, target2);
        assert result2.length == 2 : "Test 2.1 failed";
        assert (nums2[result2[0]] + nums2[result2[1]] == target2) : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: nums=[3,2,4], target=6 -> " + 
                         java.util.Arrays.toString(result2));
        
        // Test 3: Mismo número dos veces
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = sol.twoSum(nums3, target3);
        assert result3.length == 2 : "Test 3.1 failed";
        assert (nums3[result3[0]] + nums3[result3[1]] == target3) : "Test 3.2 failed";
        System.out.println("✓ Test 3 passed: nums=[3,3], target=6 -> " + 
                         java.util.Arrays.toString(result3));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

