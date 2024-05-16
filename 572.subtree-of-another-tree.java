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
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return recurTraverse(root, subRoot);
    }

    public boolean recurTraverse(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            if(isSameTree(root, subRoot)) {
                return true;
            }
        }
        boolean l = recurTraverse(root.left, subRoot);
        if (l) {
            return true;
        }
        boolean r = recurTraverse(root.right, subRoot);
        return r;
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
