import java.util.*;

/**
 * LeetCode 239 - Sliding Window Maximum
 * 
 * Problem Description:
 * You are given an array of integers nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * 
 * Return the max sliding window.
 * 
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * 
 * Solution Approach:
 * We use a Deque (double-ended queue) to maintain indices:
 * 1. The deque maintains indices in decreasing order of values
 * 2. Remove indices outside the current window
 * 3. Remove indices with values smaller than current (can't be maximums)
 * 4. Add current index to deque
 * 5. The window maximum is the value at the index at the front of deque
 * 
 * Time Complexity: O(n) - each index is added and removed at most once
 * Space Complexity: O(k)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remover índices fuera de la ventana
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remover índices con valores menores (no pueden ser máximos)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Agregar máximo a resultado cuando la ventana está completa
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 239 - Sliding Window Maximum ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = sol.maxSlidingWindow(nums1, k1);
        int[] expected1 = {3, 3, 5, 5, 6, 7};
        assert Arrays.equals(result1, expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Un elemento
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = sol.maxSlidingWindow(nums2, k2);
        assert result2[0] == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

