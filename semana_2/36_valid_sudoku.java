import java.util.*;

/**
 * 36 - Valid Sudoku
 * 
 * Descripción del problema:
 * Determinar si un tablero de Sudoku 9x9 es válido. Solo las celdas llenas necesitan
 * ser validadas según las siguientes reglas:
 * - Cada fila debe contener dígitos 1-9 sin repetición
 * - Cada columna debe contener dígitos 1-9 sin repetición
 * - Cada uno de los 9 sub-cuadros 3x3 debe contener dígitos 1-9 sin repetición
 * 
 * Enfoque de solución:
 * Usamos Sets para rastrear dígitos vistos en filas, columnas y sub-cuadros:
 * 1. Para cada celda con valor, verificamos si ya existe en su fila, columna o sub-cuadro
 * 2. Usamos strings únicos como claves: "row-i-num", "col-j-num", "box-boxId-num"
 * 3. Si encontramos duplicado, retornamos false
 * 
 * Time Complexity: O(1) - siempre 81 celdas
 * Space Complexity: O(1) - máximo 81*3 entradas
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                
                // Crear claves únicas
                String rowKey = "row-" + i + "-" + num;
                String colKey = "col-" + j + "-" + num;
                String boxKey = "box-" + (i / 3) + "-" + (j / 3) + "-" + num;
                
                // Verificar duplicados
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 36 - Valid Sudoku ===");
        Solution sol = new Solution();
        
        // Test 1: Tablero válido
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assert sol.isValidSudoku(board1) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Tablero válido");
        
        // Test 2: Duplicado en fila
        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assert sol.isValidSudoku(board2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Duplicado detectado");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

