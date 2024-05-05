/*
 * @lc app=leetcode id=1343 lang=java
 *
 * [1343] Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int beg = 0;
        int end = k - 1;

        while (end < arr.length) {

            System.out.println("beg : " + beg + " end : " + end + " sum : " + sum);

            if (sum / k >= threshold) {
                cnt++;
            }
            // move
            sum = sum - arr[beg];
            beg++;

            end++;
            if (end < arr.length) {
                sum = sum + arr[end];
            }
        }

        return cnt;
    }
}
// @lc code=end
