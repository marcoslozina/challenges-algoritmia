/**
 * 543 - Diameter of Binary Tree
 * 
 * Descripción del problema:
 * Dada la raíz de un árbol binario, encontrar el diámetro del árbol.
 * El diámetro es la longitud del camino más largo entre dos nodos cualesquiera.
 * Este camino puede o no pasar por la raíz.
 * 
 * Enfoque de solución:
 * Usamos recursión con estado:
 * 1. Para cada nodo, calculamos la altura de sus subárboles izquierdo y derecho
 * 2. El diámetro que pasa por este nodo = altura_izq + altura_der
 * 3. Mantenemos un máximo global del diámetro
 * 4. Retornamos la altura del subárbol (1 + max(altura_izq, altura_der))
 * 
 * Time Complexity: O(n) donde n es el número de nodos
 * Space Complexity: O(h) donde h es la altura del árbol
 */
class Solution {
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // El diámetro que pasa por este nodo
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // Retornar altura del subárbol
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Test unitarios
    public static void main(String[] args) {
        System.out.println("=== Test 543 - Diameter of Binary Tree ===");
        Solution sol = new Solution();
        
        // Test 1: Caso básico
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        int result1 = sol.diameterOfBinaryTree(root1);
        assert result1 == 3 : "Test 1 failed: expected 3, got " + result1;
        System.out.println("✓ Test 1 passed: diámetro = " + result1);
        
        // Test 2: Un solo nodo
        TreeNode root2 = new TreeNode(1);
        int result2 = sol.diameterOfBinaryTree(root2);
        assert result2 == 0 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: diámetro = " + result2);
        
        System.out.println("Todos los tests pasaron! ✓");
    }
}

