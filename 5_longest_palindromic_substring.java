/**
 * 5 - Longest Palindromic Substring
 * 
 * Descripción del problema:
 * Dado un string s, encontrar la subcadena palindrómica más larga en s.
 * 
 * Enfoque de solución:
 * Expandir desde el centro (más eficiente que DP):
 * 1. Para cada posible centro (carácter o entre dos caracteres):
 *    - Expandimos hacia ambos lados mientras los caracteres coincidan
 *    - Actualizamos el máximo si encontramos un palíndromo más largo
 * 2. Hay dos tipos de centros:
 *    - Centro en un carácter (longitud impar)
 *    - Centro entre caracteres (longitud par)
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

