/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            for(int j = i-1; j >= 0; j--) {
                if (nums[j] < val) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ret = Math.max(ret, dp[i]);
        }

        return ret;

    }
}
// @lc code=end
