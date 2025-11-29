/**
 * 104 - Maximum Depth of Binary Tree
 * 
 * Descripción del problema:
 * Dada la raíz de un árbol binario, encontrar su profundidad máxima.
 * La profundidad es el número de nodos en el camino más largo desde el nodo raíz
 * hasta el nodo hoja más lejano.
 * 
 * Enfoque de solución:
 * Usamos DFS recursivo:
 * 1. Caso base: si el nodo es null, retornamos 0
 * 2. Recursivamente calculamos la profundidad del subárbol izquierdo
 * 3. Recursivamente calculamos la profundidad del subárbol derecho
 * 4. Retornamos 1 + el máximo de ambas profundidades
 * 
 * Time Complexity: O(n) donde n es el número de nodos
 * Space Complexity: O(h) donde h es la altura del árbol (stack de recursión)
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 104 - Maximum Depth of Binary Tree ===");
        Solution sol = new Solution();
        
        // Test 1: Árbol balanceado
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        assert sol.maxDepth(root1) == 3 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: profundidad = 3");
        
        // Test 2: Árbol con un solo nodo
        TreeNode root2 = new TreeNode(1);
        assert sol.maxDepth(root2) == 1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: profundidad = 1");
        
        // Test 3: Árbol vacío
        assert sol.maxDepth(null) == 0 : "Test 3 failed";
        System.out.println("✓ Test 3 passed: profundidad = 0");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

// Definición de TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

