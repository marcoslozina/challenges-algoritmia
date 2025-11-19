/**
 * 3034 - Number of Subarrays That Match a Pattern I
 * 
 * Descripción del problema:
 * Dado un array de números y un patrón de comparaciones (-1, 0, 1), contar cuántos
 * subarrays de longitud pattern.length + 1 coinciden con el patrón.
 * El patrón representa: -1 (decrece), 0 (igual), 1 (incrementa)
 * 
 * Enfoque de solución:
 * Para cada posible inicio de subarray:
 * 1. Extraemos un subarray de longitud pattern.length + 1
 * 2. Comparamos cada par consecutivo en el subarray con el patrón correspondiente
 * 3. Convertimos la relación entre números consecutivos a -1, 0, o 1
 * 4. Si todas las comparaciones coinciden, incrementamos el contador
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

