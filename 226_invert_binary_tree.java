/**
 * 226 - Invert Binary Tree
 * 
 * Descripción del problema:
 * Dada la raíz de un árbol binario, invertir el árbol y retornar su raíz.
 * Invertir significa intercambiar los hijos izquierdo y derecho de cada nodo.
 * 
 * Enfoque de solución:
 * Usamos recursión:
 * 1. Caso base: si el nodo es null, retornamos null
 * 2. Intercambiamos los hijos izquierdo y derecho
 * 3. Recursivamente invertimos el subárbol izquierdo
 * 4. Recursivamente invertimos el subárbol derecho
 * 5. Retornamos el nodo actual
 * 
 * Time Complexity: O(n) donde n es el número de nodos
 * Space Complexity: O(h) donde h es la altura del árbol
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Intercambiar hijos
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Invertir recursivamente
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 226 - Invert Binary Tree ===");
        Solution sol = new Solution();
        
        // Test 1: Árbol básico
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        
        TreeNode inverted1 = sol.invertTree(root1);
        assert inverted1.left.val == 7 : "Test 1 failed";
        assert inverted1.right.val == 2 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Árbol invertido");
        
        // Test 2: Árbol vacío
        TreeNode inverted2 = sol.invertTree(null);
        assert inverted2 == null : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Árbol vacío");
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

