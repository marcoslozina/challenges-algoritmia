import java.util.*;

/**
 * LeetCode 242 - Valid Anagram
 * 
 * Link: https://leetcode.com/problems/valid-anagram/
 * 
 * Problem Description:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Solution Approach:
 * Count character frequencies in both strings using arrays (or HashMap).
 * If frequencies match, it's an anagram.
 * 
 * Time Complexity: O(n) where n is the length of the strings
 * Space Complexity: O(1) - fixed size array for 26 letters
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] count = new int[26];
        
        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Decrease count for characters in t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 242 - Valid Anagram ===");
        Solution sol = new Solution();
        
        // Test 1: Anagram válido
        assert sol.isAnagram("anagram", "nagaram") == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: 'anagram' and 'nagaram' -> true");
        
        // Test 2: No anagram
        assert sol.isAnagram("rat", "car") == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: 'rat' and 'car' -> false");
        
        // Test 3: Strings vacíos
        assert sol.isAnagram("", "") == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: '' and '' -> true");
        
        // Test 4: Diferentes longitudes
        assert sol.isAnagram("a", "ab") == false : "Test 4 failed";
        System.out.println("✓ Test 4 passed: 'a' and 'ab' -> false");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

