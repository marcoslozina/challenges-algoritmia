import java.util.*;

/**
 * LeetCode 155 - Min Stack
 * 
 * Link: https://leetcode.com/problems/min-stack/
 * 
 * Problem Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant O(1) time.
 * 
 * Implement the MinStack class:
 * - MinStack() initializes the stack object
 * - void push(int val) pushes the element val onto the stack
 * - void pop() removes the element on the top of the stack
 * - int top() gets the top element of the stack
 * - int getMin() retrieves the minimum element in the stack
 * 
 * Solution Approach:
 * We use two stacks:
 * 1. Main stack to store all values
 * 2. Min stack that maintains the current minimum at each level
 *    - On push, compare with current minimum and add the smaller one
 *    - On pop, remove from both stacks
 *    - getMin() returns the top of the min stack
 * 
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n)
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 155 - Min Stack ===");
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.getMin() == -3 : "Test 1.1 failed";
        minStack.pop();
        assert minStack.top() == 0 : "Test 1.2 failed";
        assert minStack.getMin() == -2 : "Test 1.3 failed";
        System.out.println("✓ Test 1 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

