/**
 * LeetCode 344 - Reverse String
 * 
 * Link: https://leetcode.com/problems/reverse-string/
 * Visual Explanation: https://neetcode.io/practice/reverse-string
 * Video Solution: https://www.youtube.com/watch?v=5keU0tNjbcY
 * 
 * Problem Description:
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Solution Approach:
 * Use two pointers technique: one at the start and one at the end.
 * Swap characters and move pointers towards the center until they meet.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) - in-place modification
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 344 - Reverse String ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(s1);
        assert java.util.Arrays.equals(s1, new char[]{'o', 'l', 'l', 'e', 'h'}) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: ['h','e','l','l','o'] -> ['o','l','l','e','h']");
        
        // Test 2: String con un carácter
        char[] s2 = {'H'};
        sol.reverseString(s2);
        assert java.util.Arrays.equals(s2, new char[]{'H'}) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: ['H'] -> ['H']");
        
        // Test 3: String par
        char[] s3 = {'H', 'a', 'n', 'n', 'a', 'h'};
        sol.reverseString(s3);
        assert java.util.Arrays.equals(s3, new char[]{'h', 'a', 'n', 'n', 'a', 'H'}) : "Test 3 failed";
        System.out.println("✓ Test 3 passed: ['H','a','n','n','a','h'] -> ['h','a','n','n','a','H']");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

