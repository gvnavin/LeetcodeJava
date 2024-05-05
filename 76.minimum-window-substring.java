/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charCnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCnt.merge(c, 1, (v1, v2) -> v1 + 1);
        }
        HashMap<Character, Integer> charCntInWindow = new HashMap<>();
        int beg = 0;
        int end = 0;

        int minLen = Integer.MAX_VALUE;
        String res = "";

        while (end < s.length()) {
            char ec = s.charAt(end);
            charCntInWindow.merge(ec, 1, (v1, v2) -> v1 + 1);
            while (check(charCntInWindow, charCnt)) {

                if (end - beg + 1 < minLen) {
                    minLen = end - beg + 1;
                    if (end + 1 < s.length()) {
                        res = s.substring(beg, end + 1);
                    } else {
                        res = s.substring(beg);
                    }
                }
                char bc = s.charAt(beg);
                charCntInWindow.merge(bc, 0, (v1, v2) -> v1 - 1);
                beg++;
            }
            end++;
        }

        return res;

    }

    boolean check(HashMap<Character, Integer> charCntInWindow, HashMap<Character, Integer> charCnt) {
        for (char c : charCnt.keySet()) {
            if (charCntInWindow.getOrDefault(c, 0) < charCnt.get(c)) {
                return false;
            }
        }
        return true;
    }
    // Time complexity: O(n)
    // Space complexity: O(n

}
// @lc code=end
