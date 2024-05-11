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

            while (end < s.length()) {
                char ec = s.charAt(end);
                mp.merge(ec, 1, (v1, v2) -> v1 + 1);
                int maxFreq = findMaxFreq(mp);
                int localSize = end - beg + 1;

                System.out.println(
                        "1 beg : " + beg + " end : " + end + " maxFreq : " + maxFreq + " mp : " + mp + " max : "
                                + max + " lsz : " + localSize);

                if (maxFreq + k > max) {
                    max = maxFreq + k;
                }

                if (localSize <= maxFreq + k && end < s.length()) {
                    end++;
                } else {
                    break;
                }
            }

            boolean endInc = false;
            if (end == s.length()) {
                endInc = true;
                end--;
            }

            while (beg <= end && beg < s.length()) {
                char bc = s.charAt(beg);
                mp.merge(bc, 0, (v1, v2) -> v1 - 1);
                int maxFreq = findMaxFreq(mp);
                int localSize = end - beg + 1;

                System.out.println(
                        "2 beg : " + beg + " end : " + end + " maxFreq : " + maxFreq + " mp : " + mp + " max : "
                                + max + " lsz : " + localSize);

                if (maxFreq + k > max) {
                    max = maxFreq + k;
                }

                if (localSize > maxFreq + k) {
                    beg++;
                } else {
                    break;
                }

            }

            if (endInc) {
                end++;
            }

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
