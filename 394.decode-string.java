/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            stk.push(c + "");
            check(stk);
        }
        String tmpStr = "";
        while (!stk.isEmpty() && !stk.peek().equals("[")) {
            String topStr = stk.pop();
            tmpStr = topStr + tmpStr;
        }
        return tmpStr;
    }

    public static void check(Stack<String> stk) {
        if (!stk.peek().equals("]")) {
            return;
        }

        String tmpStr = getStringWithinParenthesis(stk);
        int cnt = getCnt(stk);
        String multiplyString = getMultipliedString(tmpStr, cnt);
        stk.push(multiplyString);
    }

    private static String getMultipliedString(String tmpStr, int cnt) {
        String multiplyString = "";
        for (int i = 0; i < cnt; i++) {
            multiplyString += tmpStr;
        }
        return multiplyString;
    }

    private static int getCnt(Stack<String> stk) {
        // number
        String tmpCnt = "";
        while (!stk.isEmpty() && isNumber(stk.peek())) {
            String topStr = stk.pop();
            tmpCnt = topStr + tmpCnt;
        }

        int cnt = Integer.valueOf(tmpCnt);
        return cnt;
    }

    private static String getStringWithinParenthesis(Stack<String> stk) {
        stk.pop(); // ]
        String tmpStr = "";
        while (!stk.isEmpty() && !stk.peek().equals("[")) {
            String topStr = stk.pop();
            tmpStr = topStr + tmpStr;
        }
        stk.pop(); // [
        return tmpStr;
    }

    public static boolean isNumber(String s) {
        if (s.length() != 1) {
            return false;
        }

        char c = s.charAt(0);
        if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }
}
// @lc code=end
