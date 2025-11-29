import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 * 
 * Problem Description:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * Example:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Solution Approach:
 * We use a HashMap where the key is the sorted representation of characters:
 * 1. For each string, sort its characters to create a unique key
 * 2. Group all strings that have the same key (same characters)
 * 3. Return a list with all groups
 * 
 * Alternative: We could use a character count array as key for O(n) instead of O(k log k)
 * 
 * Time Complexity: O(n * k * log(k)) donde n es número de strings, k es longitud promedio
 * Space Complexity: O(n * k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Ordenar caracteres para crear clave única
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Agregar a la lista correspondiente
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 49 - Group Anagrams ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = sol.groupAnagrams(strs1);
        assert result1.size() == 3 : "Test 1 failed: expected 3 groups";
        System.out.println("✓ Test 1 passed: " + result1.size() + " grupos");
        
        // Test 2: Un solo string
        String[] strs2 = {""};
        List<List<String>> result2 = sol.groupAnagrams(strs2);
        assert result2.size() == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed");
        
        // Test 3: Sin anagramas
        String[] strs3 = {"a"};
        List<List<String>> result3 = sol.groupAnagrams(strs3);
        assert result3.size() == 1 : "Test 3 failed";
        System.out.println("✓ Test 3 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

