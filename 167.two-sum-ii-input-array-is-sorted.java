/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int beg = 0;
        int end = numbers.length - 1;
        while (beg < end) {
            int sum = numbers[beg] + numbers[end];
            if (sum == target) {
                return new int[] { beg + 1, end + 1 }; 
                //0 based indices are not working
                //so used 1 based indices
            } else if (sum > target) {
                end--;
            } else {
                beg++;
            }
        }
        return new int[2];
    }
}
// @lc code=end
