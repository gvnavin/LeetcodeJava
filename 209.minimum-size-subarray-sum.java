/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int beg = 0;
        int end = 0;

        int total = 0;
        int min = Integer.MAX_VALUE;

        while (end < nums.length) {
            total += nums[end];
            // System.out.println("beg : " + beg + " end : " + end + " total : " + total);
            if (total >= target) {
                int lsz = end - beg + 1;
                if (lsz < min) {
                    min = lsz;
                }
            }
            while (beg <= end && beg < nums.length && total >= target) {
                total -= nums[beg];
                beg++;
                if (total >= target) {
                    int lsz = end - beg + 1;
                    if (lsz < min) {
                        min = lsz;
                    }
                }
            }
            end++;
        }

        if (min >= Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }
}
// @lc code=end
