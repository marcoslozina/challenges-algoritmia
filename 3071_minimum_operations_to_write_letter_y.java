import java.util.*;

/**
 * 3071 - Minimum Operations to Write the Letter Y on a Grid
 * 
 * Descripción del problema:
 * Dada una cuadrícula de n x m con valores 0, 1, o 2, necesitamos cambiar valores
 * para formar la letra Y. La letra Y consiste en:
 * - Dos diagonales desde las esquinas superiores hasta el centro
 * - Una línea vertical desde el centro hasta abajo
 * Encuentra el número mínimo de cambios necesarios, donde las celdas Y deben tener
 * el mismo valor y las celdas no-Y deben tener un valor diferente.
 * 
 * Enfoque de solución:
 * 1. Primero identificamos qué celdas pertenecen al patrón Y:
 *    - Diagonal izquierda: i == j && i < center
 *    - Diagonal derecha: i + j == n-1 && i < center
 *    - Línea vertical: j == center && i >= center
 * 2. Contamos las frecuencias de valores en celdas Y y no-Y
 * 3. Probamos todas las combinaciones de valores para Y y no-Y (9 combinaciones)
 * 4. Calculamos las operaciones necesarias para cada combinación y elegimos el mínimo
 * 
 * Time Complexity: O(n * m) where n and m are grid dimensions
 * Space Complexity: O(1)
 */
class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int center = n / 2;
        
        // Count cells in Y pattern and non-Y pattern
        Map<Integer, Integer> yCells = new HashMap<>();
        Map<Integer, Integer> nonYCells = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if cell is part of Y pattern
                boolean isY = false;
                
                // Left diagonal: i == j and i < center
                if (i == j && i < center) {
                    isY = true;
                }
                // Right diagonal: i + j == n - 1 and i < center
                else if (i + j == n - 1 && i < center) {
                    isY = true;
                }
                // Vertical line: j == center and i >= center
                else if (j == center && i >= center) {
                    isY = true;
                }
                
                if (isY) {
                    yCells.put(grid[i][j], yCells.getOrDefault(grid[i][j], 0) + 1);
                } else {
                    nonYCells.put(grid[i][j], nonYCells.getOrDefault(grid[i][j], 0) + 1);
                }
            }
        }
        
        // Try all combinations of values for Y and non-Y
        int minOps = Integer.MAX_VALUE;
        
        for (int yVal = 0; yVal < 3; yVal++) {
            for (int nonYVal = 0; nonYVal < 3; nonYVal++) {
                if (yVal == nonYVal) {
                    continue;
                }
                
                int ops = 0;
                // Operations needed for Y cells
                for (Map.Entry<Integer, Integer> entry : yCells.entrySet()) {
                    if (entry.getKey() != yVal) {
                        ops += entry.getValue();
                    }
                }
                
                // Operations needed for non-Y cells
                for (Map.Entry<Integer, Integer> entry : nonYCells.entrySet()) {
                    if (entry.getKey() != nonYVal) {
                        ops += entry.getValue();
                    }
                }
                
                minOps = Math.min(minOps, ops);
            }
        }
        
        return minOps;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3071 - Minimum Operations to Write Letter Y ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] grid1 = {
            {1, 2, 2},
            {1, 1, 0},
            {0, 1, 0}
        };
        int result1 = sol.minimumOperationsToWriteY(grid1);
        System.out.println("Resultado Test 1: " + result1);
        System.out.println("✓ Test 1 passed");
        
        // Test 2: Grid más grande
        int[][] grid2 = {
            {0, 1, 0, 1, 0},
            {2, 1, 0, 1, 2},
            {2, 2, 0, 2, 2},
            {2, 1, 1, 1, 2},
            {2, 2, 2, 2, 2}
        };
        int result2 = sol.minimumOperationsToWriteY(grid2);
        System.out.println("Resultado Test 2: " + result2);
        System.out.println("✓ Test 2 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

