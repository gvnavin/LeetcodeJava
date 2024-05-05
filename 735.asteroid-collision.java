/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int ast : asteroids) {
            if (!stk.isEmpty() && stk.peek() > 0 && ast < 0) {
                while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(ast)) {
                    stk.pop();
                }
                if (!stk.isEmpty() && stk.peek() == Math.abs(ast)) {
                    stk.pop();
                } else if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(ast);
                }
            } else {
                stk.push(ast);
            }
        }
        int ret[] = new int[stk.size()];
        int i = stk.size() - 1;
        while (!stk.isEmpty()) {
            ret[i] = stk.pop();
            i--;
        }
        return ret;
    }
}
// @lc code=end
