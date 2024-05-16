/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// not working for some test cases
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode node = recurTraverse(root, subRoot);
        return isSameTree(node, subRoot);
    }

    public TreeNode recurTraverse(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return null;
        }

        if (root.val == subRoot.val) {
            return root;
        }
        TreeNode left = recurTraverse(root.left, subRoot);
        if (left != null) {
            return left;
        }
        return recurTraverse(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);

        return l && r;

    }

}
// @lc code=end
