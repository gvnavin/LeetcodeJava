/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueToIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (valueToIndexMap.containsKey(diff) && valueToIndexMap.get(diff) != i) {
                return new int[] {i, valueToIndexMap.get(diff)};
            }
        }
        return new int[]{};
    }
}
// @lc code=end
