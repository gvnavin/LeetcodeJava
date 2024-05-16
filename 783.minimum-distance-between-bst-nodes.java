/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public int minDiffInBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        recur(root, inorder);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < inorder.size(); i++) {
            int val = inorder.get(i) - inorder.get(i - 1);
            min = Math.min(min, val);
        }
        return min;
    }

    void recur(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        recur(root.left, inorder);
        inorder.add(root.val);
        recur(root.right, inorder);

    }
}
// @lc code=end
