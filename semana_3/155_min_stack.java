import java.util.*;

/**
 * 155 - Min Stack
 * 
 * Descripción del problema:
 * Diseñar un stack que soporte push, pop, top y obtener el elemento mínimo en tiempo O(1).
 * 
 * Enfoque de solución:
 * Usamos dos stacks:
 * 1. Stack principal para almacenar todos los valores
 * 2. Stack de mínimos que mantiene el mínimo actual en cada nivel
 *    - Al hacer push, comparamos con el mínimo actual y agregamos el menor
 *    - Al hacer pop, removemos de ambos stacks
 *    - getMin() retorna el tope del stack de mínimos
 * 
 * Time Complexity: O(1) para todas las operaciones
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

