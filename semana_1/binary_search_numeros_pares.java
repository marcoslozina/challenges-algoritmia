/**
 * Binary Search - Números Pares
 * 
 * Problem Description:
 * Given a sorted array of integers, find the first even number using binary search.
 * If no even number exists, return -1.
 * 
 * Example:
 * Input: nums = [1, 3, 5, 6, 8, 10]
 * Output: 3 (index of first even number: 6)
 * 
 * Input: nums = [1, 3, 5, 7]
 * Output: -1 (no even numbers)
 * 
 * Solution Approach:
 * Use binary search to find the first even number.
 * If current number is even, check if it's the first one (previous is odd or we're at start).
 * 
 * Time Complexity: O(log n) where n is the length of nums
 * Space Complexity: O(1)
 */
class Solution {
    public int findFirstEven(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] % 2 == 0) {
                // Found an even number, check if it's the first one
                result = mid;
                right = mid - 1; // Continue searching left
            } else {
                // Odd number, search right
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test Binary Search - Números Pares ===");
        Solution sol = new Solution();
        
        // Test 1: Array con números pares
        int[] nums1 = {1, 3, 5, 6, 8, 10};
        int result1 = sol.findFirstEven(nums1);
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        assert nums1[result1] == 6 : "Test 1.2 failed";
        System.out.println("✓ Test 1 passed: [1,3,5,6,8,10] -> index " + result1);
        
        // Test 2: Sin números pares
        int[] nums2 = {1, 3, 5, 7};
        int result2 = sol.findFirstEven(nums2);
        assert result2 == -1 : "Test 2 failed: expected -1, got " + result2;
        System.out.println("✓ Test 2 passed: [1,3,5,7] -> -1");
        
        // Test 3: Todos pares
        int[] nums3 = {2, 4, 6, 8};
        int result3 = sol.findFirstEven(nums3);
        assert result3 == 0 : "Test 3 failed: expected 0, got " + result3;
        System.out.println("✓ Test 3 passed: [2,4,6,8] -> index " + result3);
        
        // Test 4: Un solo elemento par
        int[] nums4 = {1, 2};
        int result4 = sol.findFirstEven(nums4);
        assert result4 == 1 : "Test 4 failed: expected 1, got " + result4;
        System.out.println("✓ Test 4 passed: [1,2] -> index " + result4);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

