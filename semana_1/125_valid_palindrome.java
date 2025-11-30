/**
 * LeetCode 125 - Valid Palindrome
 * 
 * Link: https://leetcode.com/problems/valid-palindrome/
 * Visual Explanation: https://neetcode.io/practice/valid-palindrome
 * Video Solution: https://www.youtube.com/watch?v=jJXJ16kPFWg
 * 
 * Problem Description:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Solution Approach:
 * Use two pointers: one from start, one from end.
 * Skip non-alphanumeric characters and compare characters (case-insensitive).
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 125 - Valid Palindrome ===");
        Solution sol = new Solution();
        
        // Test 1: Palíndromo válido
        assert sol.isPalindrome("A man, a plan, a canal: Panama") == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: 'A man, a plan, a canal: Panama' -> true");
        
        // Test 2: No palíndromo
        assert sol.isPalindrome("race a car") == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: 'race a car' -> false");
        
        // Test 3: String vacío
        assert sol.isPalindrome(" ") == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: ' ' -> true");
        
        // Test 4: Palíndromo simple
        assert sol.isPalindrome("racecar") == true : "Test 4 failed";
        System.out.println("✓ Test 4 passed: 'racecar' -> true");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

