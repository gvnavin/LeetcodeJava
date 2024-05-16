/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    static class Node {
        int foundCnt;
        TreeNode lca;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q).lca;
    }

    public Node recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Node();
        }

        Node ret = new Node();
        if (root.val == p.val) {
            ret.foundCnt++;
        }
        if (root.val == q.val) {
            ret.foundCnt++;
        }
        Node l = recur(root.left, p, q);
        Node r = recur(root.right, p, q);

        ret.foundCnt += l.foundCnt;
        ret.foundCnt += r.foundCnt;

        if (ret.foundCnt == 2) {
            if (l.lca != null) {
                ret.lca = l.lca;
            } else if (r.lca != null) {
                ret.lca = r.lca;
            } else {
                ret.lca = root;
            }
        }

        return ret;
    }
}
// @lc code=end
