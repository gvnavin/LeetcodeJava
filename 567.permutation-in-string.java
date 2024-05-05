/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> charToCntMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charToCntMap.merge(c, 1, (v1, v2) -> v1 + 1);
        }
        int windowSz = s1.length();

        HashMap<Character, Integer> newCharToCntMap = new HashMap<>();
        for (int i = 0; i < Math.min(windowSz, s2.length()); i++) {
            char c = s2.charAt(i);
            newCharToCntMap.merge(c, 1, (v1, v2) -> v1 + 1);
        }
        int beg = 0;
        int end = windowSz - 1;
        while (end < s2.length()) {
            if (compare(charToCntMap, newCharToCntMap)) {
                return true;
            }
            char bc = s2.charAt(beg);
            int newCnt = newCharToCntMap.merge(bc, 0, (v1, v2) -> v1 - 1);
            if (newCnt == 0) {
                newCharToCntMap.remove(bc);
            }
            beg++;
            end++;
            if (end < s2.length()) {
                char ec = s2.charAt(end);
                newCharToCntMap.merge(ec, 1, (v1, v2) -> v1 + 1);
            }

        }
        return false;
    }

    private boolean compare(HashMap<Character, Integer> charToCntMap, HashMap<Character, Integer> newCharToCntMap) {
        System.out.println(charToCntMap + " " + newCharToCntMap);
        for (Map.Entry<Character, Integer> entry : charToCntMap.entrySet()) {
            int cnt = newCharToCntMap.getOrDefault(entry.getKey(), 0);
            if (cnt != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
