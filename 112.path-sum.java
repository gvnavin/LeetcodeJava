/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recur(root, targetSum);
    }

    private boolean recur(TreeNode root, int targetSum) {
        if (root != null && root.left == null && root.right == null && targetSum == root.val) {
            return true;
        } else if (root != null && root.left == null && root.right == null && targetSum != root.val) {
            return false;
        } else if (root == null) {
            return false;
        }

        boolean l = recur(root.left, targetSum - root.val);
        boolean r = recur(root.right, targetSum - root.val);
        return l || r;
    }

}
// @lc code=end
