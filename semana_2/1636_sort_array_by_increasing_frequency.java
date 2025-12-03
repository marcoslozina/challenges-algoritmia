import java.util.*;

/**
 * LeetCode 1636 - Sort Array by Increasing Frequency
 * 
 * Link: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Visual Explanation: https://neetcode.io/practice/sort-array-by-increasing-frequency
 * Video Solution: https://www.youtube.com/results?search_query=leetcode+1636
 * 
 * Problem Description:
 * Given an array of integers nums, sort the array in increasing order based on the frequency 
 * of the values. If multiple values have the same frequency, sort them in decreasing order.
 * 
 * Example 1:
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * 
 * Example 2:
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * 
 * Example 3:
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * 
 * Solution Approach:
 * 1. Count frequency of each element using HashMap
 * 2. Convert to list of entries [value, frequency]
 * 3. Sort by frequency (ascending), then by value (descending) for ties
 * 4. Reconstruct the result array by repeating each value according to its frequency
 * 
 * Time Complexity: O(n log n) where n is the array size (due to sorting)
 * Space Complexity: O(n) for HashMap and result array
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        // Contar frecuencias
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Convertir a lista para ordenar
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
        
        // Ordenar: primero por frecuencia creciente, luego por valor decreciente
        Collections.sort(entries, (a, b) -> {
            int freqCompare = a.getValue().compareTo(b.getValue());
            if (freqCompare != 0) {
                return freqCompare; // Frecuencia creciente
            }
            return b.getKey().compareTo(a.getKey()); // Valor decreciente si hay empate
        });
        
        // Reconstruir el array resultado
        int[] result = new int[nums.length];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result[idx++] = value;
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 1636 - Sort Array by Increasing Frequency ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] result1 = sol.frequencySort(nums1);
        int[] expected1 = {3, 1, 1, 2, 2, 2};
        assert Arrays.equals(result1, expected1) : "Test 1 failed: expected " + Arrays.toString(expected1) + ", got " + Arrays.toString(result1);
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Empates en frecuencia
        int[] nums2 = {2, 3, 1, 3, 2};
        int[] result2 = sol.frequencySort(nums2);
        int[] expected2 = {1, 3, 3, 2, 2};
        assert Arrays.equals(result2, expected2) : "Test 2 failed: expected " + Arrays.toString(expected2) + ", got " + Arrays.toString(result2);
        System.out.println("✓ Test 2 passed: " + Arrays.toString(result2));
        
        // Test 3: Números negativos
        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] result3 = sol.frequencySort(nums3);
        int[] expected3 = {5, -1, 4, 4, -6, -6, 1, 1, 1};
        assert Arrays.equals(result3, expected3) : "Test 3 failed: expected " + Arrays.toString(expected3) + ", got " + Arrays.toString(result3);
        System.out.println("✓ Test 3 passed: " + Arrays.toString(result3));
        
        // Test 4: Un solo elemento
        int[] nums4 = {1};
        int[] result4 = sol.frequencySort(nums4);
        assert result4.length == 1 && result4[0] == 1 : "Test 4 failed";
        System.out.println("✓ Test 4 passed: " + Arrays.toString(result4));
        
        // Test 5: Todos iguales
        int[] nums5 = {2, 2, 2};
        int[] result5 = sol.frequencySort(nums5);
        int[] expected5 = {2, 2, 2};
        assert Arrays.equals(result5, expected5) : "Test 5 failed";
        System.out.println("✓ Test 5 passed: " + Arrays.toString(result5));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

