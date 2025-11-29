import java.util.*;

/**
 * 3161 - Block Placement Queries
 * 
 * Descripción del problema:
 * Dado un array de queries, donde cada query puede ser:
 * - Agregar un obstáculo en una posición
 * - Consultar si se puede colocar un bloque de cierto tamaño en una posición específica
 * Un bloque de tamaño 'size' puede colocarse en posición 'idx' si hay al menos 'size' espacios
 * consecutivos libres (sin obstáculos) que incluyan o precedan a 'idx'.
 * 
 * Enfoque de solución:
 * Mantenemos una lista ordenada de obstáculos usando búsqueda binaria:
 * 1. Para agregar obstáculo: insertamos en orden usando binary search (O(log n))
 * 2. Para consultar: buscamos el último obstáculo antes de la posición objetivo
 *    y verificamos si hay espacio suficiente para el bloque
 * 3. Usamos Collections.binarySearch para mantener la lista ordenada eficientemente
 * 
 * Time Complexity: O(n * log(n)) where n is the number of queries
 * Space Complexity: O(n)
 */
class Solution {
    public List<Boolean> getResults(int[][] queries) {
        List<Integer> obstacles = new ArrayList<>();
        obstacles.add(0); // Start with left boundary
        List<Boolean> result = new ArrayList<>();
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Add obstacle
                int pos = query[1];
                int idx = Collections.binarySearch(obstacles, pos);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                obstacles.add(idx, pos);
            } else {
                // Query
                int size = query[1];
                int targetIdx = query[2];
                
                // Binary search for the last obstacle before targetIdx
                int pos = Collections.binarySearch(obstacles, targetIdx);
                if (pos < 0) {
                    pos = -(pos + 1) - 1;
                } else {
                    pos--;
                }
                
                int lastObstacle = obstacles.get(pos);
                
                // Check if we can place block of size 'size' at position targetIdx
                if (targetIdx - lastObstacle >= size) {
                    result.add(true);
                } else {
                    // Check if we can place it before the last obstacle
                    if (pos > 0) {
                        int prevObstacle = obstacles.get(pos - 1);
                        if (targetIdx - prevObstacle >= size) {
                            result.add(true);
                        } else {
                            result.add(false);
                        }
                    } else {
                        result.add(false);
                    }
                }
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3161 - Block Placement Queries ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] queries1 = {
            {1, 2}, {2, 3, 2}, {2, 3, 1}, {1, 5}, {2, 3, 2}
        };
        List<Boolean> result1 = sol.getResults(queries1);
        assert result1.size() == 3 : "Test 1.1 failed";
        assert result1.get(0) == true : "Test 1.2 failed";
        assert result1.get(1) == false : "Test 1.3 failed";
        assert result1.get(2) == true : "Test 1.4 failed";
        System.out.println("✓ Test 1 passed: Caso básico");
        
        // Test 2: Sin obstáculos
        int[][] queries2 = {
            {2, 3, 2}, {2, 3, 1}
        };
        List<Boolean> result2 = sol.getResults(queries2);
        assert result2.get(0) == true : "Test 2.1 failed";
        assert result2.get(1) == true : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: Sin obstáculos");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

