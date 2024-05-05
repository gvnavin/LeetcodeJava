/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

// not working
class Solution {
    public boolean find132pattern(int[] nums) {

        int[] mini = new int[nums.length];
        mini[0] = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            mini[i] = min;
        }

        // System.out.println("mini : " + Arrays.toString(mini));

        Stack<Integer> stk = new Stack<>();
        stk.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (mini[i] < nums[i]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (mini[i] < nums[j] && nums[j] < nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end
