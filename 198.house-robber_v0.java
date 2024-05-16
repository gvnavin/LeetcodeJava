/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        return Math.max(
                recur(nums, 0, nums.length - 2, 0),
                recur(nums, 1, nums.length - 1, 1));
    }

    public int recur(int[] nums, int beg, int end, int i) {
        if (i > end) {
            return 0;
        }

        int val1 = nums[i] + recur(nums, beg, end, i + 2);
        int val2 = recur(nums, beg, end, i);
        int val3 = recur(nums, beg, end, i + 1);

        return Math.max(Math.max(val1, val2), val3);
    }
}
// @lc code=end
