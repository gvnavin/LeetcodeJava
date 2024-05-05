/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        int beg = 0;
        int end = k - 1;
        int[] ret = new int[nums.length - k + 1];
        int i = 0;
        while (end < nums.length) {
            ret[i] = pq.peek();
            i++;
            
            pq.remove(nums[beg]);
            beg++;
            
            end++;
            if (end < nums.length) {
                pq.add(nums[end]);
            }
        }
        return ret;
    }
}
// @lc code=end
