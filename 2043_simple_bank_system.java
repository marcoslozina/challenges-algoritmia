/**
 * LeetCode 2043 - Simple Bank System
 * 
 * Descripción del problema:
 * Tienes un sistema bancario que maneja múltiples cuentas. Implementa la clase Bank:
 * 
 * - Bank(long[] balance): Inicializa el objeto con las cuentas desde 1 hasta n.
 * - boolean transfer(int account1, int account2, long money): Transfiere money de account1 a account2.
 *   Retorna true si la transacción fue exitosa, false en caso contrario.
 * - boolean deposit(int account, long money): Deposita money en account. Retorna true si exitoso.
 * - boolean withdraw(int account, long money): Retira money de account. Retorna true si exitoso.
 * 
 * Todas las operaciones deben validar que las cuentas existan (1-indexed) y que haya fondos suficientes.
 * 
 * Enfoque de solución:
 * Utilizamos un array para almacenar los balances de cada cuenta. Cada operación:
 * 1. Valida que las cuentas estén en el rango válido (1-indexed)
 * 2. Verifica que haya fondos suficientes para transferencias y retiros
 * 3. Actualiza los balances directamente en O(1)
 * 
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n) where n is the number of accounts
 */
class Bank {
    private long[] balance;
    private int n;
    
    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 < 1 || account1 > n || account2 < 1 || account2 > n) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (account < 1 || account > n) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (account < 1 || account > n) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 2043 - Simple Bank System ===");
        
        // Test 1: Operaciones básicas
        Bank bank1 = new Bank(new long[]{10, 100, 20, 50, 30});
        assert bank1.withdraw(3, 10) == true : "Test 1.1 failed";
        assert bank1.transfer(5, 1, 20) == true : "Test 1.2 failed";
        assert bank1.deposit(5, 20) == true : "Test 1.3 failed";
        assert bank1.transfer(3, 4, 15) == false : "Test 1.4 failed";
        System.out.println("✓ Test 1 passed: Operaciones básicas");
        
        // Test 2: Validación de cuentas
        Bank bank2 = new Bank(new long[]{100});
        assert bank2.withdraw(2, 10) == false : "Test 2.1 failed";
        assert bank2.deposit(0, 10) == false : "Test 2.2 failed";
        System.out.println("✓ Test 2 passed: Validación de cuentas");
        
        // Test 3: Fondos insuficientes
        Bank bank3 = new Bank(new long[]{10, 20});
        assert bank3.withdraw(1, 20) == false : "Test 3.1 failed";
        assert bank3.transfer(1, 2, 15) == false : "Test 3.2 failed";
        System.out.println("✓ Test 3 passed: Fondos insuficientes");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

