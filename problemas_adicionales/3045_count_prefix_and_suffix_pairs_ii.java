/**
 * LeetCode 3045 - Count Prefix and Suffix Pairs II
 * 
 * Link: https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/
 * 
 * Problem Description:
 * You are given a 0-indexed string array words.
 * 
 * Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
 * - isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2,
 *   and false otherwise.
 * 
 * For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa"
 * and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
 * 
 * Return an integer denoting the number of index pairs (i, j) such that i < j, and
 * isPrefixAndSuffix(words[i], words[j]) is true.
 * 
 * Solution Approach:
 * For each pair of words (i, j) where i < j:
 * 1. Verify word1 has length less than or equal to word2
 * 2. Use startsWith() to verify if it's a prefix
 * 3. Use endsWith() to verify if it's a suffix
 * 4. If both conditions are met, increment counter
 * 
 * Time Complexity: O(n * m) where n is number of words, m is average word length
 * Space Complexity: O(1)
 */
class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        long count = 0;
        int n = words.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String word1 = words[i];
                String word2 = words[j];
                
                // Check if word1 is both prefix and suffix of word2
                if (word1.length() <= word2.length()) {
                    if (word2.startsWith(word1) && word2.endsWith(word1)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 3045 - Count Prefix and Suffix Pairs II ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String[] words1 = {"a", "aba", "ababa", "aa"};
        long result1 = sol.countPrefixSuffixPairs(words1);
        assert result1 == 4 : "Test 1 failed: expected 4, got " + result1;
        System.out.println("✓ Test 1 passed: Caso básico");
        
        // Test 2: Sin pares
        String[] words2 = {"pa", "papa", "ma", "mama"};
        long result2 = sol.countPrefixSuffixPairs(words2);
        assert result2 == 2 : "Test 2 failed: expected 2, got " + result2;
        System.out.println("✓ Test 2 passed: Sin pares");
        
        // Test 3: Palabras iguales
        String[] words3 = {"abab", "ab"};
        long result3 = sol.countPrefixSuffixPairs(words3);
        assert result3 == 0 : "Test 3 failed: expected 0, got " + result3;
        System.out.println("✓ Test 3 passed: Palabras iguales");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

