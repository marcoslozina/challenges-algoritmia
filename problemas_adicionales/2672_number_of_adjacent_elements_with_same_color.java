import java.util.Arrays;

/**
 * 2672 - Number of Adjacent Elements With the Same Color
 * 
 * Descripción del problema:
 * Dado un array de tamaño n inicialmente con ceros, y una serie de queries que
 * colorean un índice con un color, devolver después de cada query el número de
 * pares de elementos adyacentes que tienen el mismo color.
 * 
 * Enfoque de solución:
 * Mantenemos un contador de pares adyacentes con el mismo color:
 * 1. Para cada query, primero removemos las contribuciones del color anterior:
 *    - Si el elemento izquierdo tenía el mismo color, decrementamos
 *    - Si el elemento derecho tenía el mismo color, decrementamos
 * 2. Actualizamos el color en el índice
 * 3. Agregamos las nuevas contribuciones:
 *    - Si el elemento izquierdo tiene el mismo color, incrementamos
 *    - Si el elemento derecho tiene el mismo color, incrementamos
 * 4. Devolvemos el contador actual
 * 
 * Time Complexity: O(n) where n is the number of queries
 * Space Complexity: O(n)
 */
class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n];
        int[] result = new int[queries.length];
        int count = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            
            // Remove old contributions
            if (index > 0 && nums[index] != 0 && nums[index] == nums[index - 1]) {
                count--;
            }
            if (index < n - 1 && nums[index] != 0 && nums[index] == nums[index + 1]) {
                count--;
            }
            
            // Update color
            nums[index] = color;
            
            // Add new contributions
            if (index > 0 && nums[index] == nums[index - 1]) {
                count++;
            }
            if (index < n - 1 && nums[index] == nums[index + 1]) {
                count++;
            }
            
            result[i] = count;
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 2672 - Number of Adjacent Elements With Same Color ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int n1 = 4;
        int[][] queries1 = {{0, 2}, {1, 2}, {3, 1}};
        int[] result1 = sol.colorTheArray(n1, queries1);
        assert result1[0] == 0 : "Test 1.1 failed";
        assert result1[1] == 1 : "Test 1.2 failed";
        assert result1[2] == 0 : "Test 1.3 failed";
        System.out.println("✓ Test 1 passed: " + Arrays.toString(result1));
        
        // Test 2: Múltiples colores iguales
        int n2 = 1;
        int[][] queries2 = {{0, 1}, {0, 1}};
        int[] result2 = sol.colorTheArray(n2, queries2);
        assert result2[0] == 0 : "Test 2.1 failed";
        assert result2[1] == 0 : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: " + Arrays.toString(result2));
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

