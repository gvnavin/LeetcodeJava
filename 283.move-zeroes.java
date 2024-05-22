/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int back = 0;
        int front = 0;
        while (front < nums.length) {
            // System.out.println("back : " + back + " front : " + front);
            if (nums[back] != 0 && nums[front] != 0) {
                back++;
                front++;
            } else if (nums[back] == 0 && nums[front] != 0) {
                // System.out.println("before : " + Arrays.toString(nums));
                int temp = nums[back];
                nums[back] = nums[front];
                nums[front] = temp;
                // System.out.println("after : " + Arrays.toString(nums));
                front++;
                back++;
            } else if (nums[back] != 0 && nums[front] == 0) {
                front++;
            } else if (nums[back] == 0 && nums[front] == 0) {
                front++;
            }
        }
    }
}
// @lc code=end
