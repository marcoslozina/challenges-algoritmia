import java.util.*;

/**
 * LeetCode 128 - Longest Consecutive Sequence
 * 
 * Problem Description:
 * Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence. You must write an algorithm that runs in O(n) time.
 * 
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Solution Approach:
 * We use a Set to store all numbers:
 * 1. Add all numbers to a Set for O(1) lookup
 * 2. For each number, if it's the start of a sequence (doesn't have num-1):
 *    - Count how many consecutive numbers exist starting from that number
 *    - Update the maximum
 * 3. Only process sequence starts to avoid duplicate work
 * 
 * Time Complexity: O(n) - each number is visited at most 2 times
 * Space Complexity: O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longest = 0;
        
        for (int num : numSet) {
            // Solo procesar si es inicio de secuencia
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Contar secuencia consecutiva
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longest = Math.max(longest, currentStreak);
            }
        }
        
        return longest;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 128 - Longest Consecutive Sequence ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = sol.longestConsecutive(nums1);
        assert result1 == 4 : "Test 1 failed: expected 4, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Array vacío
        int[] nums2 = {};
        int result2 = sol.longestConsecutive(nums2);
        assert result2 == 0 : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        // Test 3: Un elemento
        int[] nums3 = {0};
        int result3 = sol.longestConsecutive(nums3);
        assert result3 == 1 : "Test 3 failed";
        System.out.println("✓ Test 3 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

