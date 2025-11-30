import java.util.*;

/**
 * LeetCode 232 - Implement Queue using Stacks
 * 
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * Problem Description:
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue
 * should support all the functions of a normal queue (push, peek, pop, and empty).
 * 
 * Solution Approach:
 * We use two stacks (input and output):
 * 1. push: add to input stack
 * 2. pop/peek: if output is empty, transfer all elements from input to output
 *    (this reverses the order, making first in become first out)
 * 3. pop: remove from output stack
 * 4. peek: return top of output stack
 * 5. empty: both stacks must be empty
 * 
 * Time Complexity: O(1) amortized for all operations
 * Space Complexity: O(n)
 */
class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;
    
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        peek(); // Asegurar que output tenga elementos
        return output.pop();
    }
    
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 232 - Implement Queue using Stacks ===");
        
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        assert queue.peek() == 1 : "Test 1.1 failed";
        assert queue.pop() == 1 : "Test 1.2 failed";
        assert queue.empty() == false : "Test 1.3 failed";
        assert queue.pop() == 2 : "Test 1.4 failed";
        assert queue.empty() == true : "Test 1.5 failed";
        System.out.println("✓ Test 1 passed");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

