import java.util.*;

/**
 * LeetCode 150 - Evaluate Reverse Polish Notation
 * 
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Problem Description:
 * You are given an array of strings tokens that represents an arithmetic expression
 * in Reverse Polish Notation. Evaluate the expression and return an integer that represents
 * the value of the expression.
 * 
 * Valid operators are '+', '-', '*', and '/'. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * 
 * Example:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * Solution Approach:
 * We use a Stack to store operands:
 * 1. If we find a number, add it to the stack
 * 2. If we find an operator:
 *    - Remove the two top operands (b, a)
 *    - Apply the operation: a operator b
 *    - Add the result to the stack
 * 3. At the end, stack contains a single element: the result
 * 
 * Time Complexity: O(n) where n is the number of tokens
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

