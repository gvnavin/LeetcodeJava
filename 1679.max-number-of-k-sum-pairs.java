/*
 * @lc app=leetcode id=1679 lang=java
 *
 * [1679] Max Number of K-Sum Pairs
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int beg = 0;
        int end = nums.length - 1;
        int cnt = 0;
        while (beg < end) {
            if (nums[beg] + nums[end] == k) {
                beg++;
                end--;
                cnt++;
            } else if (nums[beg] + nums[end] > k) {
                end--;
            } else {
                beg++;
            }
        }
        return cnt;
    }
}
// @lc code=end
