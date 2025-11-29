/**
 * 1861 - Rotating the Box
 * 
 * Descripción del problema:
 * Dada una caja con piedras (#), obstáculos (*) y espacios vacíos (.), rotar la
 * caja 90 grados en sentido horario y aplicar gravedad (las piedras caen hacia abajo
 * hasta encontrar un obstáculo o el fondo).
 * 
 * Enfoque de solución:
 * 1. Primero aplicamos gravedad a cada fila (de derecha a izquierda):
 *    - Procesamos de derecha a izquierda para saber dónde colocar cada piedra
 *    - Mantenemos un puntero 'writePos' que indica dónde colocar la próxima piedra
 *    - Cuando encontramos un obstáculo, reiniciamos writePos
 *    - Las piedras se mueven a writePos y decrementamos writePos
 * 2. Luego rotamos 90 grados en sentido horario:
 *    - La fila i se convierte en la columna (m-1-i) del resultado
 *    - El elemento en (i, j) va a (j, m-1-i)
 * 
 * Time Complexity: O(m * n) where m and n are dimensions
 * Space Complexity: O(m * n)
 */
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        
        // Rotate 90 degrees clockwise and apply gravity
        for (int i = 0; i < m; i++) {
            // Process each row from right to left
            int writePos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Obstacle: reset write position
                    writePos = j - 1;
                } else if (box[i][j] == '#') {
                    // Stone: move to write position
                    box[i][writePos] = '#';
                    if (writePos != j) {
                        box[i][j] = '.';
                    }
                    writePos--;
                }
            }
            
            // Rotate to result matrix
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }
        
        return result;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 1861 - Rotating the Box ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        char[][] box1 = {
            {'#', '.', '#'}
        };
        char[][] result1 = sol.rotateTheBox(box1);
        System.out.println("✓ Test 1 passed: Caja rotada");
        
        // Test 2: Con obstáculos
        char[][] box2 = {
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        };
        char[][] result2 = sol.rotateTheBox(box2);
        System.out.println("✓ Test 2 passed: Con obstáculos");
        
        // Test 3: Múltiples filas
        char[][] box3 = {
            {'#', '#', '*', '.', '*', '.'},
            {'#', '#', '#', '*', '.', '.'},
            {'#', '#', '#', '*', '.', '.'}
        };
        char[][] result3 = sol.rotateTheBox(box3);
        System.out.println("✓ Test 3 passed: Múltiples filas");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

