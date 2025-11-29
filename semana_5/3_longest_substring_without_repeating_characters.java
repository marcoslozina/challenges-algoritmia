import java.util.*;

/**
 * 3 - Longest Substring Without Repeating Characters
 * 
 * Descripción del problema:
 * Dado un string, encontrar la longitud de la subcadena más larga sin caracteres repetidos.
 * 
 * Enfoque de solución:
 * Usamos Sliding Window con HashMap:
 * 1. Mantenemos dos punteros (left y right) que definen la ventana
 * 2. Usamos un HashMap para rastrear la última posición de cada carácter
 * 3. Expandimos la ventana moviendo right:
 *    - Si encontramos un carácter repetido, movemos left a max(left, última_posición + 1)
 *    - Actualizamos la posición del carácter en el HashMap
 * 4. Actualizamos el máximo en cada iteración
 * 
 * Time Complexity: O(n) donde n es la longitud del string
 * Space Complexity: O(min(n, m)) donde m es el tamaño del alfabeto
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

