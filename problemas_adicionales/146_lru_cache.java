import java.util.*;

/**
 * LeetCode 146 - LRU Cache
 * 
 * Problem Description:
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * - LRUCache(int capacity): Initialize the LRU cache with positive size capacity.
 * - int get(int key): Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value): Update the value of the key if the key exists. Otherwise,
 *   add the key-value pair to the cache. If the number of keys exceeds the capacity from
 *   this operation, evict the least recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * Solution Approach:
 * We combine two data structures:
 * 1. HashMap: for O(1) access to nodes by key
 * 2. Doubly linked list: to maintain usage order (O(1) insertion/deletion)
 * 
 * Operations:
 * - get: search in HashMap O(1), move node to front of list O(1)
 * - put: if exists, update and move to front O(1)
 *        if not exists, create node, add to front O(1)
 *        if exceeds capacity, remove last node O(1)
 * 
 * Most recent node is at the start (head.next) and least recent at the end (tail.prev).
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

