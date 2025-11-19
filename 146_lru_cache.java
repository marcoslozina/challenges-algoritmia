import java.util.*;

/**
 * 146 - LRU Cache
 * 
 * Descripción del problema:
 * Diseñar una estructura de datos LRU (Least Recently Used) Cache que soporte:
 * - get(key): obtener el valor de la clave, o -1 si no existe
 * - put(key, value): insertar o actualizar el valor
 * Cuando se alcanza la capacidad, eliminar el elemento menos recientemente usado.
 * 
 * Enfoque de solución:
 * Combinamos dos estructuras de datos:
 * 1. HashMap: para acceso O(1) a los nodos por clave
 * 2. Lista doblemente enlazada: para mantener el orden de uso (O(1) inserción/eliminación)
 * 
 * Operaciones:
 * - get: buscamos en HashMap O(1), movemos nodo al frente de la lista O(1)
 * - put: si existe, actualizamos y movemos al frente O(1)
 *        si no existe, creamos nodo, agregamos al frente O(1)
 *        si excede capacidad, eliminamos el último nodo O(1)
 * 
 * El nodo más reciente está al inicio (head.next) y el menos reciente al final (tail.prev).
 * 
 * Time Complexity: O(1) for get and put operations
 * Space Complexity: O(capacity)
 */
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move to front
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node == null) {
            // New node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            
            if (cache.size() > capacity) {
                // Remove least recently used
                Node tail = removeTail();
                cache.remove(tail.key);
            }
        } else {
            // Update existing node
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    private Node removeTail() {
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 146 - LRU Cache ===");
        
        // Test 1: Operaciones básicas
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        assert cache1.get(1) == 1 : "Test 1.1 failed";
        cache1.put(3, 3);
        assert cache1.get(2) == -1 : "Test 1.2 failed";
        cache1.put(4, 4);
        assert cache1.get(1) == -1 : "Test 1.3 failed";
        assert cache1.get(3) == 3 : "Test 1.4 failed";
        assert cache1.get(4) == 4 : "Test 1.5 failed";
        System.out.println("✓ Test 1 passed: Operaciones básicas");
        
        // Test 2: Actualización de valor
        LRUCache cache2 = new LRUCache(2);
        cache2.put(2, 1);
        cache2.put(2, 2);
        assert cache2.get(2) == 2 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Actualización de valor");
        
        // Test 3: Capacidad 1
        LRUCache cache3 = new LRUCache(1);
        cache3.put(2, 1);
        assert cache3.get(2) == 1 : "Test 3.1 failed";
        cache3.put(3, 2);
        assert cache3.get(2) == -1 : "Test 3.2 failed";
        assert cache3.get(3) == 2 : "Test 3.3 failed";
        System.out.println("✓ Test 3 passed: Capacidad 1");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

