import java.util.*;

/**
 * 128 - Longest Consecutive Sequence
 * 
 * Descripción del problema:
 * Dado un array de enteros no ordenado, encontrar la longitud de la secuencia consecutiva
 * más larga. El algoritmo debe ejecutarse en O(n).
 * 
 * Enfoque de solución:
 * Usamos un Set para almacenar todos los números:
 * 1. Agregamos todos los números a un Set para búsqueda O(1)
 * 2. Para cada número, si es el inicio de una secuencia (no tiene num-1):
 *    - Contamos cuántos números consecutivos hay empezando desde ese número
 *    - Actualizamos el máximo
 * 3. Solo procesamos inicios de secuencias para evitar trabajo duplicado
 * 
 * Time Complexity: O(n) - cada número se visita máximo 2 veces
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

