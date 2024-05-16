/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String l = tree2str(root.left);
        String r = tree2str(root.right);
        // System.out.println("1 - l: " + l + " r: " + r);
        if (l.isEmpty() && r.isEmpty()) {
            return root.val + "";
        }
        String ret = root.val + "";
        if (l.isEmpty() && !r.isEmpty()) {
            ret = ret + "()" + "(" + r + ")";
        } else if (!l.isEmpty() && r.isEmpty()) {
            ret = ret + "(" + l + ")";
        } else if (!l.isEmpty() && !r.isEmpty()) {
            ret = ret + "(" + l + ")" + "(" + r + ")";
        }
        // System.out.println("2 - " + ret);

        return ret;
    }
}
// @lc code=end
