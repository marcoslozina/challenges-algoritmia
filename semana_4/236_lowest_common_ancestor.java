/**
 * LeetCode 236 - Lowest Common Ancestor of a Binary Tree
 * 
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Problem Description:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).
 * 
 * Example:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Solution Approach:
 * We use recursion:
 * 1. If current node is null, p, or q, return the node
 * 2. Recursively search in left and right subtrees
 * 3. If both subtrees return non-null nodes, current node is the LCA
 * 4. If only one returns non-null, that is the LCA (or an ancestor of p/q)
 * 5. If both return null, there's no LCA in this subtree
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
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

