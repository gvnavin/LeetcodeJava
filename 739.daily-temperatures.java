/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Stack;

class Solution {

    public static class Node {
        int ind;
        int tmp;

        public Node(int ind, int tmp) {
            this.ind = ind;
            this.tmp = tmp;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> stk = new Stack<>();
        HashMap<Integer, Integer> indxToDayCnt = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (!stk.isEmpty() && temperatures[i] > stk.peek().tmp) {
                Node localNode = stk.pop();
                indxToDayCnt.put(localNode.ind, i - localNode.ind);
            }

            stk.push(new Node(i, temperatures[i]));
        }

        int[] ret = new int[temperatures.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = indxToDayCnt.getOrDefault(i, 0);
        }

        return ret;
    }
}
// @lc code=end
