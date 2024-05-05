/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkCnt = new Stack<>();
        Stack<String> stkStr = new Stack<>();

        String tempStr = "";
        String tempCnt = "";
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                tempStr += c;
                continue;
            }

            if (c >= '0' && c <= '9') {
                if (!tempStr.isBlank()) {
                    stkStr.push(tempStr);
                    tempStr = "";
                }
                tempCnt += c;
                continue;
            }

            if (c == '[') {
                int count = Integer.valueOf(tempCnt);
                stkCnt.push(count);
                tempCnt = "";
                continue;
            }

            if (c == ']') {
                int cnt = stkCnt.pop();
                String multiplyStr = "";
                for (int i = 0; i < cnt; i++) {
                    multiplyStr += tempStr;
                }
                tempStr = "";

                String stkTopStr = "";
                if (!stkStr.isEmpty()) {
                    stkTopStr = stkStr.pop();
                }
                tempStr = stkTopStr + multiplyStr;
                continue;
            }
        }

        String stkTopStr = "";
        if (!stkStr.isEmpty()) {
            stkTopStr = stkStr.pop();
        }
        return stkTopStr + tempStr;

    }
}
// @lc code=end
