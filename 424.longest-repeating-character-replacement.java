/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int beg = 0;
        int end = 0;

        int max = Integer.MIN_VALUE;

        while (end < s.length()) {
            char ec = s.charAt(end);
            mp.merge(ec, 1, (v1, v2) -> v1 + 1);

            int maxFreq = findMaxFreq(mp);

            int lsz = end - beg + 1;
            int min = Math.min(lsz, maxFreq + k);
            if (min > max) {
                max = min;
            }

            System.out.println("1 beg : " + beg + " end : " + end + " maxFreq : " + maxFreq + " mp : " + mp + " max : "
                    + max + " lsz : " + lsz);

            while (beg <= end && beg < s.length() && lsz > maxFreq + k) {

                System.out.println("2 beg : " + beg +
                        " end : " + end +
                        " maxFreq : " + maxFreq +
                        " mp : " + mp +
                        " max : " + max +
                        " lsz : " + lsz);

                char bc = s.charAt(beg);
                mp.merge(bc, 0, (v1, v2) -> v1 - 1);
                maxFreq = findMaxFreq(mp);
                lsz = end - beg + 1;
                min = Math.min(lsz, maxFreq + k);
                if (min > max) {
                    max = min;
                }

                beg++;
            }
            end++;
            System.out.println("--------------------------");
        }
        return max;
    }

    private int findMaxFreq(HashMap<Character, Integer> mp) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }
}
// @lc code=end
