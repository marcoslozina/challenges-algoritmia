import java.util.*;

/**
 * 71 - Simplify Path
 * 
 * Descripción del problema:
 * Dada una ruta absoluta de Unix, simplificarla. La ruta puede contener:
 * - '/' para separar directorios
 * - '.' para el directorio actual
 * - '..' para el directorio padre
 * - Múltiples '/' consecutivos deben tratarse como uno solo
 * 
 * Enfoque de solución:
 * 1. Dividimos la ruta por '/' y procesamos cada parte
 * 2. Usamos una pila (Deque) para mantener el camino actual:
 *    - Si encontramos "..", removemos el último directorio (si existe)
 *    - Si encontramos "." o "", lo ignoramos
 *    - Cualquier otro string lo agregamos a la pila
 * 3. Construimos la ruta final desde la pila, agregando "/" entre directorios
 * 4. Si la pila está vacía, devolvemos "/"
 * 
 * Time Complexity: O(n) where n is the path length
 * Space Complexity: O(n)
 */
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }
        
        return result.toString();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 71 - Simplify Path ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        String path1 = "/home/";
        String result1 = sol.simplifyPath(path1);
        assert result1.equals("/home") : "Test 1 failed: expected /home, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Con puntos
        String path2 = "/../";
        String result2 = sol.simplifyPath(path2);
        assert result2.equals("/") : "Test 2 failed: expected /, got " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Ruta compleja
        String path3 = "/home//foo/";
        String result3 = sol.simplifyPath(path3);
        assert result3.equals("/home/foo") : "Test 3 failed: expected /home/foo, got " + result3;
        System.out.println("✓ Test 3 passed: " + result3);
        
        // Test 4: Con doble punto
        String path4 = "/a/./b/../../c/";
        String result4 = sol.simplifyPath(path4);
        assert result4.equals("/c") : "Test 4 failed: expected /c, got " + result4;
        System.out.println("✓ Test 4 passed: " + result4);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

