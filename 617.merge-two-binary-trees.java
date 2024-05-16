/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recur(root1, root2);
    }

    private TreeNode recur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root1 == null && root2 != null) {
            return root2;
        }

        root1.val = root1.val + root2.val;
        
        TreeNode l = recur(root1.left, root2.left);
        TreeNode r = recur(root1.right, root2.right);

        root1.left = l;
        root1.right = r;

        return root1;
    }
}
// @lc code=end

