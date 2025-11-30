/**
 * LeetCode 226 - Invert Binary Tree
 * 
 * Link: https://leetcode.com/problems/invert-binary-tree/
 * Visual Explanation: https://neetcode.io/practice/invert-binary-tree
 * Video Solution: https://www.youtube.com/watch?v=OnSn2XOD4k4
 * 
 * Problem Description:
 * Given the root of a binary tree, invert the tree, and return its root.
 * Inverting means swapping the left and right children of each node.
 * 
 * Example:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * Solution Approach:
 * We use recursion:
 * 1. Base case: if node is null, return null
 * 2. Swap left and right children
 * 3. Recursively invert the left subtree
 * 4. Recursively invert the right subtree
 * 5. Return the current node
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
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

// Definition of TreeNode
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

