import java.util.*;

/**
 * LeetCode 20 - Valid Parentheses
 * 
 * Problem Description:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets
 * - Open brackets must be closed in the correct order
 * - Every close bracket has a corresponding open bracket of the same type
 * 
 * Example:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Solution Approach:
 * We use a Stack to track open parentheses:
 * 1. When we find an open parenthesis, add it to the stack
 * 2. When we find a close parenthesis:
 *    - If stack is empty, return false
 *    - If top of stack doesn't match the close parenthesis, return false
 *    - If it matches, remove from stack
 * 3. At the end, stack must be empty
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) in worst case
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

