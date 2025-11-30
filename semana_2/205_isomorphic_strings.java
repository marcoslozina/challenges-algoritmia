import java.util.*;

/**
 * LeetCode 205 - Isomorphic Strings
 * 
 * Link: https://leetcode.com/problems/isomorphic-strings/
 * 
 * Problem Description:
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character
 * may map to itself.
 * 
 * Example:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Solution Approach:
 * We use two HashMaps for bidirectional mapping:
 * 1. s -> t: maps each character in s to its corresponding character in t
 * 2. t -> s: maps each character in t to its corresponding character in s
 * 3. For each character pair, verify the mapping is consistent
 * 4. If we find a conflict, return false
 * 
 * Time Complexity: O(n) where n is the length of the strings
 * Space Complexity: O(1) - maximum 256 ASCII characters
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Verificar mapeo s -> t
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false;
                }
            } else {
                sToT.put(charS, charT);
            }
            
            // Verificar mapeo t -> s
            if (tToS.containsKey(charT)) {
                if (tToS.get(charT) != charS) {
                    return false;
                }
            } else {
                tToS.put(charT, charS);
            }
        }
        
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 205 - Isomorphic Strings ===");
        Solution sol = new Solution();
        
        // Test 1: Isomórficos
        assert sol.isIsomorphic("egg", "add") == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: egg y add son isomórficos");
        
        // Test 2: No isomórficos
        assert sol.isIsomorphic("foo", "bar") == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: foo y bar no son isomórficos");
        
        // Test 3: Mismo string
        assert sol.isIsomorphic("paper", "title") == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: paper y title son isomórficos");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

