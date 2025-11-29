/**
 * 53 - Maximum Subarray (Kadane's Algorithm)
 * 
 * Descripción del problema:
 * Dado un array de enteros, encontrar la subsecuencia contigua con la suma máxima.
 * 
 * Enfoque de solución:
 * Algoritmo de Kadane:
 * 1. Mantenemos dos variables:
 *    - currentSum: suma máxima que termina en el índice actual
 *    - maxSum: suma máxima global
 * 2. Para cada elemento:
 *    - currentSum = max(nums[i], currentSum + nums[i])
 *    - Si empezamos de nuevo es mejor, empezamos de nuevo
 *    - Actualizamos maxSum si currentSum es mayor
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decidir si continuar la subsecuencia o empezar de nuevo
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 53 - Maximum Subarray ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = sol.maxSubArray(nums1);
        assert result1 == 6 : "Test 1 failed: expected 6, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Un elemento
        int[] nums2 = {1};
        int result2 = sol.maxSubArray(nums2);
        assert result2 == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Todos negativos
        int[] nums3 = {-1};
        int result3 = sol.maxSubArray(nums3);
        assert result3 == -1 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

