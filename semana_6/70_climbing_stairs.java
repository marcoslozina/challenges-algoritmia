/**
 * 70 - Climbing Stairs
 * 
 * Descripción del problema:
 * Estás subiendo una escalera. Toma n pasos para llegar arriba.
 * Cada vez puedes subir 1 o 2 pasos. ¿De cuántas formas distintas puedes subir?
 * 
 * Enfoque de solución:
 * Este es básicamente el problema de Fibonacci:
 * - Para llegar al escalón n, puedes venir del escalón n-1 o n-2
 * - dp[n] = dp[n-1] + dp[n-2]
 * - Casos base: dp[1] = 1, dp[2] = 2
 * 
 * Optimización: Solo necesitamos los dos valores anteriores, así que usamos
 * variables en lugar de array para O(1) espacio.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1; // dp[1]
        int prev1 = 2; // dp[2]
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 70 - Climbing Stairs ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        assert sol.climbStairs(2) == 2 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: n=2 -> 2 formas");
        
        // Test 2: Caso más grande
        assert sol.climbStairs(3) == 3 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: n=3 -> 3 formas");
        
        // Test 3: n=5
        assert sol.climbStairs(5) == 8 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: n=5 -> 8 formas");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

