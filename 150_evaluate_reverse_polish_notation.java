import java.util.*;

/**
 * 150 - Evaluate Reverse Polish Notation
 * 
 * Descripción del problema:
 * Evaluar una expresión en notación polaca inversa (RPN). Operadores válidos: +, -, *, /
 * Cada operador opera sobre los dos números anteriores.
 * 
 * Enfoque de solución:
 * Usamos un Stack para almacenar operandos:
 * 1. Si encontramos un número, lo agregamos al stack
 * 2. Si encontramos un operador:
 *    - Removemos los dos operandos superiores (b, a)
 *    - Aplicamos la operación: a operador b
 *    - Agregamos el resultado al stack
 * 3. Al final, el stack contiene un solo elemento: el resultado
 * 
 * Time Complexity: O(n) donde n es el número de tokens
 * Space Complexity: O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 150 - Evaluate Reverse Polish Notation ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1 = sol.evalRPN(tokens1);
        assert result1 == 9 : "Test 1 failed: expected 9, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Con división
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = sol.evalRPN(tokens2);
        assert result2 == 6 : "Test 2 failed: expected 6, got " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Operaciones múltiples
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result3 = sol.evalRPN(tokens3);
        assert result3 == 22 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

