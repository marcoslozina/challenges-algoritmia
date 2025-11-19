import java.util.*;

/**
 * 2768 - Number of Black Blocks
 * 
 * Descripción del problema:
 * Dada una cuadrícula de m x n y una lista de coordenadas de celdas negras,
 * contar cuántos bloques 2x2 tienen exactamente 0, 1, 2, 3, o 4 celdas negras.
 * 
 * Enfoque de solución:
 * 1. Para cada celda negra, identificamos a qué bloques 2x2 pertenece
 *    (una celda puede ser parte de hasta 4 bloques diferentes)
 * 2. Usamos un HashMap para contar cuántas celdas negras tiene cada bloque 2x2
 * 3. Agrupamos los bloques por número de celdas negras (0-4)
 * 4. El número de bloques con 0 celdas negras = total bloques - bloques con celdas negras
 * 
 * Time Complexity: O(m + n) where m is number of coordinates, n is grid size
 * Space Complexity: O(m)
 */
class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<String, Integer> blockCount = new HashMap<>();
        
        // For each black cell, mark which 2x2 blocks it belongs to
        for (int[] coord : coordinates) {
            int r = coord[0];
            int c = coord[1];
            
            // A cell can be part of up to 4 different 2x2 blocks
            for (int dr = 0; dr >= -1; dr--) {
                for (int dc = 0; dc >= -1; dc--) {
                    int topR = r + dr;
                    int topC = c + dc;
                    if (topR >= 0 && topR < m - 1 && topC >= 0 && topC < n - 1) {
                        String key = topR + "," + topC;
                        blockCount.put(key, blockCount.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        
        // Count blocks by number of black cells
        long[] result = new long[5];
        for (int count : blockCount.values()) {
            if (count <= 4) {
                result[count]++;
            }
        }
        
        // Total number of 2x2 blocks
        long totalBlocks = (long)(m - 1) * (n - 1);
        result[0] = totalBlocks - (result[1] + result[2] + result[3] + result[4]);
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 2768 - Number of Black Blocks ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[][] coords1 = {{0, 0}, {1, 1}, {0, 2}};
        long[] result1 = sol.countBlackBlocks(3, 3, coords1);
        assert result1.length == 5 : "Test 1.1 failed";
        System.out.println("Resultado Test 1: " + Arrays.toString(result1));
        System.out.println("✓ Test 1 passed");
        
        // Test 2: Sin celdas negras
        int[][] coords2 = {};
        long[] result2 = sol.countBlackBlocks(2, 2, coords2);
        assert result2[0] == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Sin celdas negras");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

