import java.util.*;

/**
 * LeetCode 36 - Valid Sudoku
 * 
 * Problem Description:
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 * - Each row must contain the digits 1-9 without repetition
 * - Each column must contain the digits 1-9 without repetition
 * - Each of the nine 3 x 3 sub-boxes must contain the digits 1-9 without repetition
 * 
 * Solution Approach:
 * We use Sets to track seen digits in rows, columns, and sub-boxes:
 * 1. For each cell with a value, check if it already exists in its row, column, or sub-box
 * 2. Use unique strings as keys: "row-i-num", "col-j-num", "box-boxId-num"
 * 3. If we find a duplicate, return false
 * 
 * Time Complexity: O(1) - always 81 cells
 * Space Complexity: O(1) - maximum 81*3 entries
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

