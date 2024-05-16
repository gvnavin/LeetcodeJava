/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> levelToValueMap = new HashMap<>();
        recur(root, levelToValueMap, 0);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < levelToValueMap.size(); i++) {
            ret.add(levelToValueMap.get(i));
        }
        return ret;
    }

    public void recur(TreeNode root, HashMap<Integer, List<Integer>> levelToValueMap, int level) {
        if (root == null) {
            return;
        }

        List<Integer> list = levelToValueMap.getOrDefault(level, new ArrayList<>());
        list.add(root.val);
        levelToValueMap.put(level, list);

        recur(root.left, levelToValueMap, level + 1);
        recur(root.right, levelToValueMap, level + 1);
    }

}
// @lc code=end
