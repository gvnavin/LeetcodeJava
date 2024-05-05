/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start

import java.util.Stack;

class StockSpanner {

    static class Node {
        int price;
        int daysCnt;

        public Node(int price, int daysCnt) {
            this.price = price;
            this.daysCnt = daysCnt;
        }

    }

    private Stack<Node> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        Node node = new Node(price, 1);
        while (!stk.isEmpty() && stk.peek().price <= node.price) {
            node.daysCnt += stk.pop().daysCnt;
        }

        stk.push(node);
        return node.daysCnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end
