import java.util.*;

/**
 * 739 - Daily Temperatures
 * 
 * Descripción del problema:
 * Dado un array de temperaturas diarias, devolver un array donde answer[i] es el número
 * de días que tienes que esperar después del día i para obtener una temperatura más alta.
 * Si no hay un día futuro con temperatura más alta, answer[i] = 0.
 * 
 * Enfoque de solución:
 * Usamos un Stack monótono decreciente:
 * 1. Mantenemos un stack con índices de días
 * 2. Para cada día, mientras la temperatura actual sea mayor que la del tope del stack:
 *    - Calculamos la diferencia de días (índice actual - índice del tope)
 *    - Actualizamos answer[índice del tope] con la diferencia
 *    - Removemos el índice del stack
 * 3. Agregamos el índice actual al stack
 * 
 * Time Complexity: O(n) - cada índice se agrega y remueve máximo una vez
 * Space Complexity: O(n)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return answer;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 739 - Daily Temperatures ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = sol.dailyTemperatures(temps1);
        int[] expected1 = {1, 1, 4, 2, 1, 1, 0, 0};
        assert Arrays.equals(result1, expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Temperaturas decrecientes
        int[] temps2 = {30, 40, 50, 60};
        int[] result2 = sol.dailyTemperatures(temps2);
        int[] expected2 = {1, 1, 1, 0};
        assert Arrays.equals(result2, expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

