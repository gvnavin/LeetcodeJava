/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public boolean isBalanced(TreeNode root) {
        return recur(root).isBalanced;
    }

    public static class Node {
        int height;
        boolean isBalanced;

        public Node() {
            height = 0;
            isBalanced = true;
        }

        public Node(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        @Override
        public String toString() {
            return "Node [isBalanced=" + isBalanced + ", height=" + height + "]";
        }

    }

    public Node recur(TreeNode root) {

        if (root == null) {
            return new Node();
        }

        Node l = recur(root.left);
        Node r = recur(root.right);

        int newHeight = Math.max(l.height, r.height) + 1;

        // System.out.println("root.val : " + root.val + " l : " + l + " r : " + r);

        if (!l.isBalanced || !r.isBalanced) {
            return new Node(newHeight, false);
        }

        int diff = Math.abs(l.height - r.height);
        boolean isBalanced = true;
        if (diff > 1) {
            isBalanced = false;
        }

        Node ret = new Node(newHeight, isBalanced);

        return ret;

    }
}
// @lc code=end
