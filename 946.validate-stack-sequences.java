/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int pushi = 0, popi = 0;
        while (pushi < pushed.length && popi < popped.length) {

            // System.out.println("stk : " + stk + " pushi : " + pushi + " popi : " + popi);

            if (stk.isEmpty()) {
                if (pushi < pushed.length) {
                    stk.push(pushed[pushi]);
                    pushi++;
                }
            }
            while (!stk.isEmpty() && popi < popped.length && stk.peek() != popped[popi] && pushi < pushed.length) {
                stk.push(pushed[pushi]);
                pushi++;
            }
            while (!stk.isEmpty() && popi < popped.length && stk.peek() == popped[popi]) {
                stk.pop();
                popi++;
            }
        }
        if (stk.isEmpty()) {
            return true;
        }

        return false;
    }
}
// @lc code=end
