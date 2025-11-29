import java.util.*;

/**
 * 202 - Happy Number
 * 
 * Descripción del problema:
 * Un número feliz es un número que eventualmente llega a 1 cuando reemplazamos el número
 * por la suma de los cuadrados de sus dígitos. Si entra en un ciclo, no es feliz.
 * 
 * Enfoque de solución:
 * Usamos un Set para detectar ciclos:
 * 1. Calculamos la suma de cuadrados de dígitos
 * 2. Si llegamos a 1, retornamos true
 * 3. Si encontramos un número que ya vimos, hay ciclo -> retornamos false
 * 4. Agregamos el número actual al set y continuamos
 * 
 * Time Complexity: O(log n) - número de iteraciones hasta ciclo o 1
 * Space Complexity: O(log n) - números únicos en el ciclo
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 202 - Happy Number ===");
        Solution sol = new Solution();
        
        // Test 1: Número feliz
        assert sol.isHappy(19) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: 19 es feliz");
        
        // Test 2: Número no feliz
        assert sol.isHappy(2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: 2 no es feliz");
        
        // Test 3: Uno es feliz
        assert sol.isHappy(1) == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: 1 es feliz");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

