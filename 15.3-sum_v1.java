/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int beg = i + 1;
            int end = nums.length - 1;
            while (beg < end) {
                // System.out.println("i = " + i + " beg = " + beg + " end = " + end);
                int sum = nums[i] + nums[beg] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[beg]);
                    list.add(nums[end]);
                    ret.add(list);

                    int tmpBeg = beg;
                    while (beg < nums.length && nums[tmpBeg] == nums[beg]) {
                        beg++;
                    }
                    int tmpEnd = end;
                    while (end > 0 && nums[tmpEnd] == nums[end]) {
                        end--;
                    }
                } else if (sum < 0) {
                    beg++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<List<Integer>>(ret);
    }
}
// @lc code=end
