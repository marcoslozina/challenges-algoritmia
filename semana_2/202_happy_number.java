import java.util.*;

/**
 * LeetCode 202 - Happy Number
 * 
 * Link: https://leetcode.com/problems/happy-number/
 * Visual Explanation: https://neetcode.io/practice/happy-number
 * Video Solution: https://www.youtube.com/watch?v=ljz85bxOYJ0
 * 
 * Problem Description:
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly
 * - Those numbers for which this process ends in 1 are happy
 * 
 * Solution Approach:
 * We use a Set to detect cycles:
 * 1. Calculate the sum of squares of digits
 * 2. If we reach 1, return true
 * 3. If we find a number we've seen before, there's a cycle -> return false
 * 4. Add the current number to the set and continue
 * 
 * Time Complexity: O(log n) - number of iterations until cycle or 1
 * Space Complexity: O(log n) - unique numbers in the cycle
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

