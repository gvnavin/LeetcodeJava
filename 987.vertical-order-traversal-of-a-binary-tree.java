/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

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

    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(this, obj);
        }

        @Override
        public int compareTo(Node o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + "]";
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Node, List<Integer>> nodeToValueMap = new TreeMap<>();
        recur(root, nodeToValueMap, 0, 0);

        Map<Integer, List<Integer>> levelToValueMap = new TreeMap<>();
        for (Node key : nodeToValueMap.keySet()) {
            List<Integer> list = nodeToValueMap.get(key);
            // System.out.println("key: " + key + "list 1 : " + list);
            Collections.sort(list);
            // System.out.println("key: " + key + "list 2 : " + list);
            List<Integer> newList = levelToValueMap.getOrDefault(key.x, new ArrayList<>());
            newList.addAll(list);
            levelToValueMap.put(key.x, newList);
            // System.out.println("key: " + key + "levelToValueMap : " + levelToValueMap);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (Integer key : levelToValueMap.keySet()) {
            ret.add(levelToValueMap.get(key));
        }
        return ret;
    }

    public void recur(TreeNode root, Map<Node, List<Integer>> nodeToValueMap, int leftOrRight, int level) {
        if (root == null) {
            return;
        }

        Node key = new Node(leftOrRight, level);

        // System.out.println("1 key: " + key + " root.val: " + root.val + "
        // nodeToValueMap: " + nodeToValueMap);

        List<Integer> list = nodeToValueMap.getOrDefault(key, new ArrayList<>());
        list.add(root.val);
        nodeToValueMap.put(key, list);

        // System.out.println("2 key: " + key + " root.val: " + root.val + "
        // nodeToValueMap: " + nodeToValueMap);

        recur(root.left, nodeToValueMap, leftOrRight - 1, level + 1);
        recur(root.right, nodeToValueMap, leftOrRight + 1, level + 1);

        System.out.println("------------");
    }
}
// @lc code=end
