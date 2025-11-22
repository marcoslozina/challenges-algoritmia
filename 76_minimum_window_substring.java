import java.util.*;

/**
 * 76 - Minimum Window Substring
 * 
 * Descripción del problema:
 * Dados dos strings s y t, encontrar la ventana mínima en s que contenga todos los
 * caracteres de t (incluyendo duplicados). Si no existe, retornar string vacío.
 * 
 * Enfoque de solución:
 * Usamos Sliding Window con dos punteros:
 * 1. Contamos la frecuencia de caracteres en t
 * 2. Expandimos la ventana moviendo right hasta tener todos los caracteres necesarios
 * 3. Cuando tenemos todos los caracteres, contraemos la ventana moviendo left:
 *    - Actualizamos el mínimo si encontramos una ventana más pequeña
 *    - Removemos caracteres del inicio hasta que ya no tengamos todos los caracteres
 * 4. Repetimos hasta recorrer todo el string
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

