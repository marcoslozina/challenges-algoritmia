/**
 * 198 - House Robber
 * 
 * Descripción del problema:
 * Eres un ladrón planeando robar casas en una calle. Cada casa tiene cierta cantidad de dinero.
 * No puedes robar dos casas adyacentes. ¿Cuál es la cantidad máxima que puedes robar?
 * 
 * Enfoque de solución:
 * DP 1D:
 * - dp[i] = máximo dinero que podemos robar hasta la casa i
 * - Para cada casa, tenemos dos opciones:
 *   1. Robar esta casa: nums[i] + dp[i-2]
 *   2. No robar esta casa: dp[i-1]
 * - dp[i] = max(dp[i-1], nums[i] + dp[i-2])
 * 
 * Optimización: Solo necesitamos los dos valores anteriores.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = 0; // dp[i-2]
        int prev1 = nums[0]; // dp[i-1]
        
        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 198 - House Robber ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        int[] nums1 = {1, 2, 3, 1};
        int result1 = sol.rob(nums1);
        assert result1 == 4 : "Test 1 failed: expected 4, got " + result1;
        System.out.println("✓ Test 1 passed: " + result1);
        
        // Test 2: Dos casas
        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = sol.rob(nums2);
        assert result2 == 12 : "Test 2 failed: expected 12, got " + result2;
        System.out.println("✓ Test 2 passed: " + result2);
        
        // Test 3: Una casa
        int[] nums3 = {2};
        int result3 = sol.rob(nums3);
        assert result3 == 2 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: " + result3);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

