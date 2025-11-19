import java.util.*;

/**
 * 84 - Largest Rectangle in Histogram
 * 
 * Descripción del problema:
 * Dado un array de alturas que representa un histograma, encontrar el área del
 * rectángulo más grande que se puede formar dentro del histograma.
 * 
 * Enfoque de solución:
 * Usamos una pila monótona para mantener índices de barras en orden creciente:
 * 1. Para cada barra, mientras la barra actual sea menor que la del tope de la pila:
 *    a. Calculamos el área del rectángulo formado por la barra del tope
 *    b. El ancho se extiende desde el índice anterior en la pila hasta el actual
 * 2. Agregamos un 0 al final para procesar todas las barras restantes
 * 3. Mantenemos el área máxima encontrada
 * 
 * La clave es que cuando encontramos una barra más baja, sabemos que las barras
 * más altas en la pila no pueden extenderse más a la derecha.
 * 
 * Time Complexity: O(n) where n is the number of bars
 * Space Complexity: O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 84 - Largest Rectangle in Histogram ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int result1 = sol.largestRectangleArea(heights1);
        assert result1 == 10 : "Test 1 failed: expected 10, got " + result1;
        System.out.println("✓ Test 1 passed: expected 10, got " + result1);
        
        // Test 2: Alturas crecientes
        int[] heights2 = {2, 4};
        int result2 = sol.largestRectangleArea(heights2);
        assert result2 == 4 : "Test 2 failed: expected 4, got " + result2;
        System.out.println("✓ Test 2 passed: expected 4, got " + result2);
        
        // Test 3: Una barra
        int[] heights3 = {1};
        int result3 = sol.largestRectangleArea(heights3);
        assert result3 == 1 : "Test 3 failed: expected 1, got " + result3;
        System.out.println("✓ Test 3 passed: expected 1, got " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

