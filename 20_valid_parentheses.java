import java.util.*;

/**
 * 20 - Valid Parentheses
 * 
 * Descripción del problema:
 * Dado un string que contiene solo '(', ')', '{', '}', '[' y ']', determinar si los
 * paréntesis están balanceados. Un string está balanceado si:
 * - Paréntesis abiertos deben cerrarse en el orden correcto
 * - Cada paréntesis cerrado tiene su correspondiente abierto
 * 
 * Enfoque de solución:
 * Usamos un Stack para rastrear paréntesis abiertos:
 * 1. Cuando encontramos un paréntesis abierto, lo agregamos al stack
 * 2. Cuando encontramos un paréntesis cerrado:
 *    - Si el stack está vacío, retornamos false
 *    - Si el tope del stack no coincide con el paréntesis cerrado, retornamos false
 *    - Si coincide, removemos del stack
 * 3. Al final, el stack debe estar vacío
 * 
 * Time Complexity: O(n) donde n es la longitud del string
 * Space Complexity: O(n) en el peor caso
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 20 - Valid Parentheses ===");
        Solution sol = new Solution();
        
        // Test 1: Válido
        assert sol.isValid("()") == true : "Test 1.1 failed";
        assert sol.isValid("()[]{}") == true : "Test 1.2 failed";
        assert sol.isValid("([{}])") == true : "Test 1.3 failed";
        System.out.println("✓ Test 1 passed: Paréntesis válidos");
        
        // Test 2: Inválido
        assert sol.isValid("(]") == false : "Test 2.1 failed";
        assert sol.isValid("([)]") == false : "Test 2.2 failed";
        assert sol.isValid("(") == false : "Test 2.3 failed";
        System.out.println("✓ Test 2 passed: Paréntesis inválidos detectados");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

