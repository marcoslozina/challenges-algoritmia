/**
 * LeetCode 104 - Maximum Depth of Binary Tree
 * 
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Visual Explanation: https://neetcode.io/practice/maximum-depth-of-binary-tree
 * Video Solution: https://www.youtube.com/watch?v=hTM3phVI6YQ
 * 
 * Problem Description:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * Solution Approach:
 * We use recursive DFS:
 * 1. Base case: if node is null, return 0
 * 2. Recursively calculate depth of left subtree
 * 3. Recursively calculate depth of right subtree
 * 4. Return 1 + maximum of both depths
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
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

