/**
 * LeetCode 101 - Symmetric Tree
 * 
 * Problem Description:
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * Example:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * Solution Approach:
 * We use recursion with two nodes:
 * 1. Compare the tree with itself using a helper function that takes two nodes
 * 2. Two nodes are symmetric if:
 *    - Both are null, or
 *    - They have the same value, and
 *    - Left of first is symmetric to right of second, and
 *    - Right of first is symmetric to left of second
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
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

