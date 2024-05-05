/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        int tsz = 2 * n;
        List<String> ret = new ArrayList<>();
        recur(tsz, 0, 0, "", ret);
        return ret;
    }

    private void recur(int tsz, int o, int c, String paren, List<String> ret) {
        // System.out.println(o + " " + c + " " + paren + " " + ret);
        if (paren.length() == tsz && o == c && o == tsz/2) {
            ret.add(paren);
        }

        if (o < c || o > tsz/2 || c > tsz/2) {
            return;
        }

        recur(tsz, o + 1, c, paren + "(", ret);
        recur(tsz, o, c + 1, paren + ")", ret);
    }
}
// @lc code=end
