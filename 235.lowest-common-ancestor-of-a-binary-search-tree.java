/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }

        return lca(root, p, q);

    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }

        if (root.val < p.val) {
            return lca(root.right, p, q);
        }
        return lca(root.left, p, q);
    }

}
// @lc code=end
