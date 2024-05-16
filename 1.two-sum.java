/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int beg = 0; 
        int end = nums.length - 1;
        while(beg < end) {
            if (nums[beg] + nums[end] == target) {
                return new int[] {beg, end};
            }

            if (nums[beg] + nums[end] < target) {
                beg ++;
            } else {
                end --;
            }
        }
        return new int[]{};
     }
}
// @lc code=end
