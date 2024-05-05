/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start

import java.util.Stack;

class Solution {

    static class Node {
        char c;
        int cnt;
        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            if (stk.isEmpty() || stk.peek().c != c) {
                stk.add(new Node(c, 1));
            } else {
                if (stk.peek().c == c) {
                    if (stk.peek().cnt == k-1) {
                        int tempCnt = k-1;
                        while(tempCnt > 0) {
                            stk.pop();
                            tempCnt--;
                        }
                    } else {
                        stk.add(new Node(c, stk.peek().cnt + 1));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.append(stk.pop().c);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

