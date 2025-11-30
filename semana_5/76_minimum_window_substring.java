import java.util.*;

/**
 * LeetCode 76 - Minimum Window Substring
 * 
 * Link: https://leetcode.com/problems/minimum-window-substring/
 * 
 * Problem Description:
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * 
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * 
 * Solution Approach:
 * We use Sliding Window with two pointers:
 * 1. Count frequency of characters in t
 * 2. Expand window by moving right until we have all required characters
 * 3. When we have all characters, contract window by moving left:
 *    - Update minimum if we find a smaller window
 *    - Remove characters from start until we no longer have all characters
 * 4. Repeat until we traverse the entire string
 * 
 * Time Complexity: O(|s| + |t|)
 * Space Complexity: O(|s| + |t|)
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0; // Número de caracteres únicos que tenemos en cantidad suficiente
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            // Actualizar ventana
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            // Contraer ventana
            while (valid == need.size()) {
                // Actualizar mínimo
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 76 - Minimum Window Substring ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String result1 = sol.minWindow("ADOBECODEBANC", "ABC");
        assert result1.equals("BANC") : "Test 1 failed: expected BANC, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Sin solución
        String result2 = sol.minWindow("a", "aa");
        assert result2.equals("") : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Sin solución");
        
        // Test 3: String completo
        String result3 = sol.minWindow("a", "a");
        assert result3.equals("a") : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

