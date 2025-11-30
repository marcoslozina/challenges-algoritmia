import java.util.*;

/**
 * Detectar Primer Caracter Duplicado
 * 
 * Problem Description:
 * Given a string, find the first character that appears more than once.
 * Return the character, or null if no duplicate exists.
 * 
 * Example:
 * Input: s = "abccba"
 * Output: 'b' (first duplicate character)
 * 
 * Input: s = "abcdef"
 * Output: null (no duplicates)
 * 
 * Solution Approach:
 * Use a HashSet to track seen characters. As we iterate, if we encounter
 * a character already in the set, it's the first duplicate.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the HashSet
 */
class Solution {
    public Character findFirstDuplicate(String s) {
        Set<Character> seen = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        
        return null;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test Detectar Primer Caracter Duplicado ===");
        Solution sol = new Solution();
        
        // Test 1: Caso con duplicado
        Character result1 = sol.findFirstDuplicate("abccba");
        assert result1 != null : "Test 1.1 failed";
        assert result1 == 'b' : "Test 1.2 failed: expected 'b', got " + result1;
        System.out.println("✓ Test 1 passed: 'abccba' -> '" + result1 + "'");
        
        // Test 2: Sin duplicados
        Character result2 = sol.findFirstDuplicate("abcdef");
        assert result2 == null : "Test 2 failed: expected null, got " + result2;
        System.out.println("✓ Test 2 passed: 'abcdef' -> null");
        
        // Test 3: Primer carácter duplicado
        Character result3 = sol.findFirstDuplicate("aabbcc");
        assert result3 != null : "Test 3.1 failed";
        assert result3 == 'a' : "Test 3.2 failed: expected 'a', got " + result3;
        System.out.println("✓ Test 3 passed: 'aabbcc' -> '" + result3 + "'");
        
        // Test 4: String vacío
        Character result4 = sol.findFirstDuplicate("");
        assert result4 == null : "Test 4 failed: expected null, got " + result4;
        System.out.println("✓ Test 4 passed: '' -> null");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

