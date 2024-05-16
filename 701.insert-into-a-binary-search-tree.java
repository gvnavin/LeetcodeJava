/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        recur(root, val);
        return root;
    }

    private void recur(TreeNode root, int val) {

        if (val > root.val) {
            if (root.right != null) {
                recur(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        } else {
            if (root.left != null) {
                recur(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }
    }
}
// @lc code=end
