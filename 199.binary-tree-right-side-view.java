/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> levelToValueMap = new HashMap<>();
        recur(root, levelToValueMap, 0);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < levelToValueMap.size(); i++) {
            ret.add(levelToValueMap.get(i));
        }
        return ret;
    }

    public void recur(TreeNode root, HashMap<Integer, Integer> levelToValueMap, int level) {
        if (root == null) {
            return;
        }

        levelToValueMap.put(level, root.val);
        recur(root.left, levelToValueMap, level + 1);
        recur(root.right, levelToValueMap, level + 1);
    }

}
// @lc code=end
