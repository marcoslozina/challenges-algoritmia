/**
 * LeetCode 2043 - Simple Bank System
 * 
 * Link: https://leetcode.com/problems/simple-bank-system/
 * Visual Explanation: https://neetcode.io/practice
 * 
 * Problem Description:
 * You have been tasked with writing a program for a popular bank that will automate all
 * its incoming transactions (transfer, deposit, and withdraw). The bank has n accounts
 * numbered from 1 to n.
 * 
 * Implement the Bank class:
 * - Bank(long[] balance): Initializes the object with the n accounts' balances.
 * - boolean transfer(int account1, int account2, long money): Transfers money dollars
 *   from account1 to account2. Returns true if successful, false otherwise.
 * - boolean deposit(int account, long money): Deposits money dollars into account.
 *   Returns true if successful, false otherwise.
 * - boolean withdraw(int account, long money): Withdraws money dollars from account.
 *   Returns true if successful, false otherwise.
 * 
 * All operations must validate that accounts exist (1-indexed) and have sufficient funds.
 * 
 * Solution Approach:
 * We use an array to store balances for each account. Each operation:
 * 1. Validates accounts are in valid range (1-indexed)
 * 2. Verifies sufficient funds for transfers and withdrawals
 * 3. Updates balances directly in O(1)
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

