/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {

            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - 1 >= i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int beg = j + 1;
                int end = nums.length - 1;

                while (beg < end) {
                    long sum = ((long)nums[i]) + ((long)nums[j]) + ((long)nums[beg]) + ((long)nums[end]);
                    if (sum == (long) target) {
                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[beg]);
                        list.add(nums[end]);

                        ret.add(list);
                        int tBeg = beg;
                        while (beg < nums.length && nums[tBeg] == nums[beg]) {
                            beg++;
                        }
                        int tEnd = end;
                        while (end >= 0 && nums[tEnd] == nums[end]) {
                            end--;
                        }
                    } else if (sum < target) {
                        beg++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return ret;
    }
}
// @lc code=end
