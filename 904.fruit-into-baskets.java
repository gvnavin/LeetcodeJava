/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitTypeToCntMap = new HashMap<>();
        int beg = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        while (end < fruits.length) {
            int endFruit = fruits[end];
            fruitTypeToCntMap.merge(endFruit, 1, (v1, v2) -> v1 + 1);
            if (fruitTypeToCntMap.size() <= 2) {
                int lsz = end - beg + 1;
                if (lsz > max) {
                    max = lsz;
                }
            }
            while (beg <= end && beg < fruits.length && fruitTypeToCntMap.size() > 2) {
                int begFruit = fruits[beg];
                int lCnt = fruitTypeToCntMap.merge(begFruit, 0, (v1, v2) -> v1 - 1);
                if (lCnt == 0) {
                    fruitTypeToCntMap.remove(begFruit);
                }
                beg++;
            }
            end++;
        }
        return max;
    }
}
// @lc code=end
