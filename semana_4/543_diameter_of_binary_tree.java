/**
 * LeetCode 543 - Diameter of Binary Tree
 * 
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 * Visual Explanation: https://neetcode.io/practice/diameter-of-binary-tree
 * Video Solution: https://www.youtube.com/watch?v=bkxqA8Rfv04
 * 
 * Problem Description:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes
 * in a tree. This path may or may not pass through the root.
 * 
 * Example:
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * Solution Approach:
 * We use recursion with state:
 * 1. For each node, calculate the height of its left and right subtrees
 * 2. The diameter passing through this node = left_height + right_height
 * 3. Maintain a global maximum of the diameter
 * 4. Return the subtree height (1 + max(left_height, right_height))
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
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

