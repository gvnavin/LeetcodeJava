/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        HashMap<Character, Integer> charToCntMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            char lc = s.charAt(i);
            if (vowels.contains(lc)) {
                charToCntMap.merge(lc, 1, (v1, v2) -> v1 + 1);
                cnt++;
            }
        }
        int beg = 0;
        int end = k - 1;
        int max = Integer.MIN_VALUE;
        while (end < s.length()) {
            if (cnt > max) {
                max = cnt;
            }
            char bc = s.charAt(beg);
            if (vowels.contains(bc)) {
                int bcCnt = charToCntMap.merge(bc, 0, (v1, v2) -> v1 - 1);
                if (bcCnt == 0) {
                    charToCntMap.remove(bc);
                }
                cnt--;
            }
            beg++;
            end++;
            if (end < s.length()) {
                char ec = s.charAt(end);
                if (vowels.contains(ec)) {
                    charToCntMap.merge(ec, 1, (v1, v2) -> v1 + 1);
                    cnt++;
                }
            }
        }
        return max;
    }
}
// @lc code=end
