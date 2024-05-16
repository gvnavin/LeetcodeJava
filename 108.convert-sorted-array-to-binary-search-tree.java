/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private TreeNode recur(int[] nums, int beg, int end) {

        if (end < beg) {
            return null;
        } else if (beg == end) {
            return new TreeNode(nums[beg]);
        }

        int mid = beg + (end - beg)/2;

        TreeNode node = new TreeNode(nums[mid]);

        TreeNode l = recur(nums, beg, mid-1);
        TreeNode r = recur(nums, mid+1, end);

        node.left = l;
        node.right = r;

        return node;

    }
}
// @lc code=end
