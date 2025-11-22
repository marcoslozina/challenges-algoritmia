import java.util.*;

/**
 * 49 - Group Anagrams
 * 
 * Descripción del problema:
 * Dado un array de strings, agrupar los anagramas juntos. Puedes devolver la respuesta
 * en cualquier orden. Un anagrama es una palabra o frase formada reordenando las letras
 * de otra palabra o frase.
 * 
 * Enfoque de solución:
 * Usamos un HashMap donde la clave es la representación ordenada de los caracteres:
 * 1. Para cada string, ordenamos sus caracteres para crear una clave única
 * 2. Agrupamos todos los strings que tienen la misma clave (mismos caracteres)
 * 3. Devolvemos una lista con todos los grupos
 * 
 * Alternativa: Podríamos usar un array de conteo de caracteres como clave para O(n) en lugar de O(k log k)
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

