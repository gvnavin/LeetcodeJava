/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int beg = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        HashMap<Character, Integer> charToCntMap = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            charToCntMap.merge(c, 1, (v1, v2) -> v1 + 1);

            // System.out.println("1 while beg: " + beg + ", end: " + end + " c : " + c);

            if (isNotRepeating(charToCntMap)) {
                if (end - beg + 1 > max) {
                    max = end - beg + 1;
                }
            }
            while (beg < s.length() && beg <= end && isRepeating(charToCntMap)) {
                // System.out.println("2 while beg: " + beg + ", end: " + end + " c : " + c);

                char bc = s.charAt(beg);
                int cnt = charToCntMap.get(bc);
                cnt--;
                charToCntMap.put(bc, cnt);
                beg++;
            }
            end++;
        }

        if (max < 0) {
            return 0;
        }

        return max;
    }

    private boolean isRepeating(HashMap<Character, Integer> charToCntMap) {
        return !isNotRepeating(charToCntMap);
    }

    private boolean isNotRepeating(HashMap<Character, Integer> charToCntMap) {
        for (Map.Entry<Character, Integer> entry : charToCntMap.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
