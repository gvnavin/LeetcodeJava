/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TLE
// 31/73 cases passed (N/A)

class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> inp = new ArrayList<>();
        inp.add(1);
        for (int i = 0; i < nums.length; i++) {
            inp.add(nums[i]);
        }
        inp.add(1);
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return recur(inp, memo);
    }

    public int recur(List<Integer> inp, Map<String, Integer> memo) {

        String key = getKey(inp);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < inp.size() - 1; i++) {
            int val = inp.get(i - 1) * inp.get(i) * inp.get(i + 1);
            ArrayList<Integer> newInp = new ArrayList<>(inp);
            // System.out.println("1 : newInp = " + newInp);
            newInp.remove(i);
            // System.out.println("2 : newInp = " + newInp);
            int l = val + recur(newInp, memo);
            // System.out.println("3 : l = " + l);
            maxi = Math.max(l, maxi);
            // System.out.println("4 : maxi = " + maxi);
        }
        if (maxi < 0) {
            maxi = 0;
        }

        memo.put(key, maxi);

        return maxi;
    }

    public String getKey(List<Integer> inp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inp.size(); i++) {
            sb.append(inp.get(i));
            sb.append("|");
        }
        return sb.toString();
    }
}
// @lc code=end
