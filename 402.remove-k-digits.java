/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }

        Stack<Character> stk = new Stack<>();
        for (char c : num.toCharArray()) {
            // System.out.println("c : " + c);
            // System.out.println("beg: stk : " + stk);

            while (!stk.isEmpty() && stk.peek() > c && k > 0) {
                stk.pop();
                k--;
            }
            stk.push(c);
            // System.out.println("end stk : " + stk);
            // System.out.println("------------------");
        }

        String tmpStr = "";
        while (!stk.isEmpty()) {
            Character pop = stk.pop();
            if (k <= 0) {
                tmpStr = pop + tmpStr;
            } else {
                k--;
            }
        }

        int st = 0;
        for (int i = 0; i < tmpStr.length(); i++) {
            char c = tmpStr.charAt(i);
            // System.out.println("c : " + c);
            if (c != '0') {
                st = i;
                break;
            }

            if (i == tmpStr.length() - 1) {
                st = i;
                break;
            }
        }
        // System.out.println("st : " + st);
        String substring = tmpStr.substring(st);
        // System.out.println("substring : " + substring);
        if (k >= substring.length()) {
            return "0";
        }
        return substring;
    }
}
// @lc code=end
