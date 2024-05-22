/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.equals(t)) {
            return true;
        }

        int si = 0;
        int ti = 0;

        while (ti < t.length()) {

            // System.out.println("si = " + si + " ti = " + ti);

            if (si < s.length() && s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }

            if (si == s.length()) {
                return true;
            }

        }

        return false;
    }
}
// @lc code=end
