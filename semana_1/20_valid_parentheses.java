import java.util.*;

/**
 * LeetCode 20 - Valid Parentheses
 * 
 * Link: https://leetcode.com/problems/valid-parentheses/
 * Visual Explanation: https://neetcode.io/practice/valid-parentheses
 * Video Solution: https://www.youtube.com/watch?v=WTzjTskDFMg
 * 
 * Problem Description:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example:
 * Input: s = "()"
 * Output: true
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * Solution Approach:
 * Use a stack to track opening brackets. When we encounter a closing bracket,
 * check if it matches the most recent opening bracket.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the stack
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
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
        
        // Test 1: Paréntesis válidos
        assert sol.isValid("()") == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: '()' -> true");
        
        // Test 2: Múltiples tipos válidos
        assert sol.isValid("()[]{}") == true : "Test 2 failed";
        System.out.println("✓ Test 2 passed: '()[]{}' -> true");
        
        // Test 3: Paréntesis inválidos
        assert sol.isValid("(]") == false : "Test 3 failed";
        System.out.println("✓ Test 3 passed: '(]' -> false");
        
        // Test 4: Anidados válidos
        assert sol.isValid("([{}])") == true : "Test 4 failed";
        System.out.println("✓ Test 4 passed: '([{}])' -> true");
        
        // Test 5: Sin cerrar
        assert sol.isValid("([") == false : "Test 5 failed";
        System.out.println("✓ Test 5 passed: '([' -> false");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

