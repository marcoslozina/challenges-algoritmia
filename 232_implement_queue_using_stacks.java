import java.util.*;

/**
 * 232 - Implement Queue using Stacks
 * 
 * Descripción del problema:
 * Implementar una cola (FIFO) usando solo dos stacks. La cola debe soportar:
 * push(x), pop(), peek(), y empty().
 * 
 * Enfoque de solución:
 * Usamos dos stacks (input y output):
 * 1. push: agregamos al stack de input
 * 2. pop/peek: si output está vacío, transferimos todos los elementos de input a output
 *    (esto invierte el orden, haciendo que el primero en entrar sea el primero en salir)
 * 3. pop: removemos del stack de output
 * 4. peek: retornamos el tope del stack de output
 * 5. empty: ambos stacks deben estar vacíos
 * 
 * Time Complexity: O(1) amortizado para todas las operaciones
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

