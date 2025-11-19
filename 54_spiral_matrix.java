import java.util.*;

/**
 * 54 - Spiral Matrix
 * 
 * Descripción del problema:
 * Dada una matriz de m x n, devolver todos los elementos en orden espiral (en sentido
 * horario): empezando desde la esquina superior izquierda, moviéndose a la derecha,
 * luego abajo, luego a la izquierda, y luego arriba, repitiendo el patrón.
 * 
 * Enfoque de solución:
 * Usamos cuatro punteros para definir los límites actuales:
 * - top, bottom: filas superior e inferior
 * - left, right: columnas izquierda y derecha
 * 
 * Iteramos mientras top <= bottom y left <= right:
 * 1. Recorremos de izquierda a derecha en la fila superior
 * 2. Recorremos de arriba a abajo en la columna derecha
 * 3. Si aún hay filas, recorremos de derecha a izquierda en la fila inferior
 * 4. Si aún hay columnas, recorremos de abajo a arriba en la columna izquierda
 * 
 * Después de cada dirección, ajustamos los límites correspondientes.
 * 
 * Time Complexity: O(m * n) where m and n are matrix dimensions
 * Space Complexity: O(1) excluding output array
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 54 - Spiral Matrix ===");
        Solution sol = new Solution();
        
        // Test 1: Matriz 3x3
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result1 = sol.spiralOrder(matrix1);
        List<Integer> expected1 = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assert result1.equals(expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Matriz 3x4
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        List<Integer> result2 = sol.spiralOrder(matrix2);
        List<Integer> expected2 = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assert result2.equals(expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Matriz 1x1
        int[][] matrix3 = {{1}};
        List<Integer> result3 = sol.spiralOrder(matrix3);
        assert result3.equals(Arrays.asList(1)) : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

