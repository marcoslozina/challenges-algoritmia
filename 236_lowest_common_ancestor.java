/**
 * 236 - Lowest Common Ancestor of a Binary Tree
 * 
 * Descripción del problema:
 * Dada la raíz de un árbol binario y dos nodos p y q, encontrar el ancestro común más bajo (LCA).
 * El LCA es el nodo más profundo que tiene tanto p como q como descendientes.
 * 
 * Enfoque de solución:
 * Usamos recursión:
 * 1. Si el nodo actual es null, p o q, retornamos el nodo
 * 2. Buscamos recursivamente en los subárboles izquierdo y derecho
 * 3. Si ambos subárboles retornan un nodo no-null, el nodo actual es el LCA
 * 4. Si solo uno retorna no-null, ese es el LCA (o un ancestro de p/q)
 * 5. Si ambos retornan null, no hay LCA en este subárbol
 * 
 * Time Complexity: O(n) donde n es el número de nodos
 * Space Complexity: O(h) donde h es la altura del árbol
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root; // Este nodo es el LCA
        }
        
        return left != null ? left : right;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 236 - Lowest Common Ancestor ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        
        TreeNode p1 = root1.left; // 5
        TreeNode q1 = root1.right; // 1
        TreeNode lca1 = sol.lowestCommonAncestor(root1, p1, q1);
        assert lca1 == root1 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: LCA = " + lca1.val);
        
        // Test 2: LCA es un ancestro
        TreeNode p2 = root1.left; // 5
        TreeNode q2 = root1.left.right.right; // 4
        TreeNode lca2 = sol.lowestCommonAncestor(root1, p2, q2);
        assert lca2 == root1.left : "Test 2 failed";
        System.out.println("✓ Test 2 passed: LCA = " + lca2.val);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

