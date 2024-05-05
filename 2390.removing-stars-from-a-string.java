/*
 * @lc app=leetcode id=2390 lang=java
 *
 * [2390] Removing Stars From a String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stk.pop();
                continue;
            }

            stk.push(c);
        }
        String tempStr = "";
        while (!stk.isEmpty()) {
            tempStr = stk.pop() + tempStr;
        }
        return tempStr;
    }
}
// @lc code=end
