/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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

    public static class Node {
        int diameter;
        int height;

        public Node() {
            diameter = 0;
            height = 0;
        }

        public Node(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Node [diameter=" + diameter + ", height=" + height + "]";
        }

    }

    public int diameterOfBinaryTree(TreeNode root) {
        return recur(root).diameter;
    }

    public Node recur(TreeNode root) {

        if (root == null) {
            return new Node();
        }

        Node l = recur(root.left);
        Node r = recur(root.right);

        // System.out.println("root.value : " + root.val + " l : " + l + " r : " + r);

        int newDiameter = l.height + r.height;
        // System.out.println("newDiameter : " + newDiameter);
        if (newDiameter > l.diameter && newDiameter > r.diameter) {
            ;
        } else if (l.diameter > r.diameter) {
            newDiameter = l.diameter;
        } else {
            newDiameter = r.diameter;
        }

        int newHeight = Math.max(l.height, r.height) + 1;
        Node ret = new Node(newDiameter, newHeight);
        // System.out.println("ret : " + ret);

        return ret;

    }

}
// @lc code=end
