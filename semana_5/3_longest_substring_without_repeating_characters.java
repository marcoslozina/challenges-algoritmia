import java.util.*;

/**
 * LeetCode 3 - Longest Substring Without Repeating Characters
 * 
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Problem Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Solution Approach:
 * We use Sliding Window with HashMap:
 * 1. Maintain two pointers (left and right) that define the window
 * 2. Use a HashMap to track the last position of each character
 * 3. Expand the window by moving right:
 *    - If we find a repeated character, move left to max(left, last_position + 1)
 *    - Update the character position in HashMap
 * 4. Update maximum in each iteration
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(min(n, m)) where m is the alphabet size
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // Si el carácter ya existe, mover left
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }
            
            charIndex.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3 - Longest Substring Without Repeating Characters ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        assert sol.lengthOfLongestSubstring("abcabcbb") == 3 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: abcabcbb -> 3");
        
        // Test 2: Todos iguales
        assert sol.lengthOfLongestSubstring("bbbbb") == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: bbbbb -> 1");
        
        // Test 3: Sin repeticiones
        assert sol.lengthOfLongestSubstring("pwwkew") == 3 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: pwwkew -> 3");
        
        // Test 4: String vacío
        assert sol.lengthOfLongestSubstring("") == 0 : "Test 4 failed";
        System.out.println("✓ Test 4 passed: '' -> 0");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

