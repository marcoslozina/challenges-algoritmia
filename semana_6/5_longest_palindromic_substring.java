/**
 * LeetCode 5 - Longest Palindromic Substring
 * 
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 * Visual Explanation: https://neetcode.io/practice/longest-palindromic-substring
 * Video Solution: https://www.youtube.com/watch?v=XYQecbcd6_c
 * 
 * Problem Description:
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * Solution Approach:
 * Expand around center (more efficient than DP):
 * 1. For each possible center (character or between two characters):
 *    - Expand to both sides while characters match
 *    - Update maximum if we find a longer palindrome
 * 2. There are two types of centers:
 *    - Center on a character (odd length)
 *    - Center between characters (even length)
 * 
 * Time Complexity: O(n^2) donde n es la longitud del string
 * Space Complexity: O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Palíndromo con centro en carácter (longitud impar)
            int len1 = expandAroundCenter(s, i, i);
            // Palíndromo con centro entre caracteres (longitud par)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 5 - Longest Palindromic Substring ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String result1 = sol.longestPalindrome("babad");
        assert result1.equals("bab") || result1.equals("aba") : "Test 1 failed: " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Palíndromo par
        String result2 = sol.longestPalindrome("cbbd");
        assert result2.equals("bb") : "Test 2 failed: " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Un carácter
        String result3 = sol.longestPalindrome("a");
        assert result3.equals("a") : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

