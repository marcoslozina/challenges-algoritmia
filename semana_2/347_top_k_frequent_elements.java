import java.util.*;

/**
 * LeetCode 347 - Top K Frequent Elements
 * 
 * Problem Description:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * 
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Solution Approach:
 * 1. Count frequency of each element using HashMap
 * 2. Use a PriorityQueue (min-heap) of size k to maintain the k most frequent
 * 3. Iterate over frequencies and keep only the k largest
 * 4. Extract elements from the heap
 * 
 * Time Complexity: O(n + m * log(k)) where n is array size, m is number of unique elements
 * Space Complexity: O(m + k)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Contar frecuencias
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Min-heap de tamaño k
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        
        // Mantener solo los k más frecuentes
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // Extraer resultados
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 347 - Top K Frequent Elements ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = sol.topKFrequent(nums1, k1);
        assert result1.length == 2 : "Test 1.1 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Un solo elemento
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = sol.topKFrequent(nums2, k2);
        assert result2[0] == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        // Test 3: Todos iguales
        int[] nums3 = {1, 1, 1, 1};
        int k3 = 1;
        int[] result3 = sol.topKFrequent(nums3, k3);
        assert result3[0] == 1 : "Test 3 failed";
        System.out.println("✓ Test 3 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

