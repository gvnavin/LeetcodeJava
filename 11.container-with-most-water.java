/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int beg = 0;
        int end = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (beg < end) {
            int width = end - beg;
            int hght = Math.min(height[beg], height[end]);
            max = Math.max(max, width * hght);
            if (height[beg] < height[end]) {
                beg++;
            } else {
                end--;
            }
        }
        return max;
    }
}
// @lc code=end
