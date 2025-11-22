import java.util.*;

/**
 * 205 - Isomorphic Strings
 * 
 * Descripción del problema:
 * Dos strings s y t son isomórficos si los caracteres en s pueden ser reemplazados para obtener t.
 * Todos los caracteres deben ser mapeados a otros caracteres preservando el orden.
 * Dos caracteres no pueden mapear al mismo carácter, pero un carácter puede mapearse a sí mismo.
 * 
 * Enfoque de solución:
 * Usamos dos HashMaps para mapeo bidireccional:
 * 1. s -> t: mapea cada carácter de s a su correspondiente en t
 * 2. t -> s: mapea cada carácter de t a su correspondiente en s
 * 3. Para cada par de caracteres, verificamos que el mapeo sea consistente
 * 4. Si encontramos conflicto, retornamos false
 * 
 * Time Complexity: O(n) donde n es la longitud de los strings
 * Space Complexity: O(1) - máximo 256 caracteres ASCII
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Verificar mapeo s -> t
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false;
                }
            } else {
                sToT.put(charS, charT);
            }
            
            // Verificar mapeo t -> s
            if (tToS.containsKey(charT)) {
                if (tToS.get(charT) != charS) {
                    return false;
                }
            } else {
                tToS.put(charT, charS);
            }
        }
        
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 205 - Isomorphic Strings ===");
        Solution sol = new Solution();
        
        // Test 1: Isomórficos
        assert sol.isIsomorphic("egg", "add") == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: egg y add son isomórficos");
        
        // Test 2: No isomórficos
        assert sol.isIsomorphic("foo", "bar") == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: foo y bar no son isomórficos");
        
        // Test 3: Mismo string
        assert sol.isIsomorphic("paper", "title") == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: paper y title son isomórficos");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

