/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] pathParts = path.split("/");
        System.out.println("pathParts : " + Arrays.deepToString(pathParts));
        for (String pathPart : pathParts) {

            if (pathPart.isBlank()) {
                continue;
            }

            if (pathPart.equals("...")) {
                stk.push(pathPart);
                continue;
            }
            if (pathPart.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
                continue;
            }
            if (pathPart.equals(".")) {
                // no-op
                continue;
            }
            stk.push(pathPart);
        }
        String joined = String.join("/", stk);
        System.out.println("joined : " + joined);
        return '/' + joined;
    }
}
// @lc code=end
