/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        return recur(grid, grid.length - 1, grid[0].length - 1);
    }

    private int recur(int[][] grid, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        // System.out.println(grid[i][j] + " " + i + " " + j);

        return grid[i][j] + Math.min(
                recur(grid, i - 1, j),
                recur(grid, i, j - 1));
    }
}
// @lc code=end
