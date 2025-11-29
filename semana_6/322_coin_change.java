import java.util.*;

/**
 * 322 - Coin Change
 * 
 * Descripción del problema:
 * Dado un array de monedas y un monto, encontrar el número mínimo de monedas necesarias
 * para hacer ese monto. Si no es posible, retornar -1.
 * 
 * Enfoque de solución:
 * DP con tabulación:
 * - dp[i] = número mínimo de monedas para hacer el monto i
 * - Para cada monto i, probamos cada moneda:
 *   - Si moneda <= i: dp[i] = min(dp[i], 1 + dp[i - moneda])
 * - Inicializamos dp[0] = 0, resto con un valor grande
 * 
 * Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Valor mayor que cualquier solución posible
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 322 - Coin Change ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int result1 = sol.coinChange(coins1, amount1);
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1 + " monedas");
        
        // Test 2: Imposible
        int[] coins2 = {2};
        int amount2 = 3;
        int result2 = sol.coinChange(coins2, amount2);
        assert result2 == -1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Imposible");
        
        // Test 3: Monto cero
        int[] coins3 = {1};
        int amount3 = 0;
        int result3 = sol.coinChange(coins3, amount3);
        assert result3 == 0 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

