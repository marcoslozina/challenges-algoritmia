import java.util.*;

/**
 * LeetCode 217 - Contains Duplicate
 * 
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Visual Explanation: https://neetcode.io/practice/contains-duplicate
 * Video Solution: https://www.youtube.com/watch?v=3OamzN90kPg
 * 
 * Problem Description:
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * 
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Solution Approach:
 * Use a HashSet to track seen numbers. If we encounter a number that's already in the set,
 * we found a duplicate.
 * 
 * Time Complexity: O(n) where n is the length of nums
 * Space Complexity: O(n) for the HashSet
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 217 - Contains Duplicate ===");
        Solution sol = new Solution();
        
        // Test 1: Caso con duplicados
        int[] nums1 = {1, 2, 3, 1};
        assert sol.containsDuplicate(nums1) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: [1,2,3,1] -> true");
        
        // Test 2: Sin duplicados
        int[] nums2 = {1, 2, 3, 4};
        assert sol.containsDuplicate(nums2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: [1,2,3,4] -> false");
        
        // Test 3: Múltiples duplicados
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assert sol.containsDuplicate(nums3) == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: [1,1,1,3,3,4,3,2,4,2] -> true");
        
        // Test 4: Array de un elemento
        int[] nums4 = {1};
        assert sol.containsDuplicate(nums4) == false : "Test 4 failed";
        System.out.println("✓ Test 4 passed: [1] -> false");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

