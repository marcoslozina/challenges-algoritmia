/**
 * 101 - Symmetric Tree
 * 
 * Descripción del problema:
 * Dada la raíz de un árbol binario, verificar si es simétrico alrededor de su centro.
 * Un árbol es simétrico si el subárbol izquierdo es un espejo del subárbol derecho.
 * 
 * Enfoque de solución:
 * Usamos recursión con dos nodos:
 * 1. Comparamos el árbol con sí mismo usando una función helper que toma dos nodos
 * 2. Dos nodos son simétricos si:
 *    - Ambos son null, o
 *    - Tienen el mismo valor, y
 *    - El izquierdo del primero es simétrico al derecho del segundo, y
 *    - El derecho del primero es simétrico al izquierdo del segundo
 * 
 * Time Complexity: O(n) donde n es el número de nodos
 * Space Complexity: O(h) donde h es la altura del árbol
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 == null || node2 == null) {
            return false;
        }
        
        return node1.val == node2.val &&
               isMirror(node1.left, node2.right) &&
               isMirror(node1.right, node2.left);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 101 - Symmetric Tree ===");
        Solution sol = new Solution();
        
        // Test 1: Árbol simétrico
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        assert sol.isSymmetric(root1) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Árbol simétrico");
        
        // Test 2: Árbol no simétrico
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        assert sol.isSymmetric(root2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Árbol no simétrico");
        
        // Test 3: Un solo nodo
        TreeNode root3 = new TreeNode(1);
        assert sol.isSymmetric(root3) == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: Un solo nodo es simétrico");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

