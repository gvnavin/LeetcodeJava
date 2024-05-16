/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Solution {

    static class Node {
        String val;
        int index;
        String key;
        List<Node> children = new ArrayList<>();

        public Node(String val, int ind) {
            this.val = val;
            this.index = ind;
            this.key = val + ind;
        }

        public Node(String val) {
            this.val = val;
            this.key = val;
        }

        // public Node addChild(String val) {
        // Node node = new Node(val);
        // children.add(node);
        // return node;
        // }

        public Node addChild(Node node) {
            children.add(node);
            return node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(this.key, ((Node) obj).key);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            for (Node child : children) {
                sb.append(child.val);
                sb.append(",");
            }

            return "Node [val=" + val + ", key=" + key + ", children=" + sb.toString() + "]";
        }

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Node> accountToNodeMap = new HashMap<>();
        for (int ii = 0; ii < accounts.size(); ii++) {
            List<String> list = accounts.get(ii);
            String account = list.get(0);
            Node defaultNodeValue = new Node(account, ii);
            Node nd = accountToNodeMap.getOrDefault(defaultNodeValue.key, defaultNodeValue);
            accountToNodeMap.put(defaultNodeValue.key, nd);

            for (int i = 1; i < list.size(); i++) {
                String laccount = list.get(i);
                Node lnd = accountToNodeMap.getOrDefault(laccount, new Node(laccount));
                accountToNodeMap.put(laccount, lnd);
                nd.addChild(lnd);
                lnd.addChild(nd);
            }
        }

        // for (Map.Entry<String, Node> entry : accountToNodeMap.entrySet()) {
        // System.out.println(entry);
        // }

        List<List<String>> ret = new ArrayList<>();
        List<String> namesRet = new ArrayList<>();
        HashMap<String, Boolean> isVisited = new HashMap<>();

        for (String acc : accountToNodeMap.keySet()) {
            Node nd = accountToNodeMap.get(acc);
            boolean isVis = isVisited.getOrDefault(nd.key, false);
            if (isVis) {
                continue;
            }

            List<String> lret = new ArrayList<>();
            Queue<Node> q = new ArrayDeque<Node>();
            q.offer(nd);
            String name = "";
            while (!q.isEmpty()) {
                Node qnd = q.poll();
                boolean isVis1 = isVisited.getOrDefault(qnd.key, false);
                if (isVis1) {
                    continue;
                }
                isVisited.put(qnd.key, true);

                if (!qnd.val.equals(qnd.key)) {
                    name = qnd.val;
                } else {
                    lret.add(qnd.val);
                }

                for (Node childNode : qnd.children) {
                    q.add(childNode);
                }
            }
            namesRet.add(name);
            ret.add(lret);
        }

        // System.out.println("---------");

        for (int i = 0; i < ret.size(); i++) {
            List<String> list = ret.get(i);
            Collections.sort(list);
            list.add(0, namesRet.get(i));
            // System.out.println(list);
        }

        return ret;
    }
}
// @lc code=end
