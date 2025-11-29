import java.util.*;

/**
 * 239 - Sliding Window Maximum
 * 
 * Descripción del problema:
 * Dado un array de enteros y un entero k, encontrar el máximo en cada ventana deslizante
 * de tamaño k.
 * 
 * Enfoque de solución:
 * Usamos un Deque (double-ended queue) para mantener índices:
 * 1. El deque mantiene índices en orden decreciente de valores
 * 2. Removemos índices fuera de la ventana actual
 * 3. Removemos índices con valores menores que el actual (no pueden ser máximos)
 * 4. Agregamos el índice actual al deque
 * 5. El máximo de la ventana es el valor en el índice del frente del deque
 * 
 * Time Complexity: O(n) - cada índice se agrega y remueve máximo una vez
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

