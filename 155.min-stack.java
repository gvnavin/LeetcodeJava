/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start

import java.util.Stack;

class MinStack {

    private Stack<Integer> stk = new Stack<>();
    private Stack<Integer> mini = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stk.push(val);
        if (mini.isEmpty() || val <= mini.peek()) {
            mini.push(val);
        }
    }

    public void pop() {
        System.out.println("beg stk : " + stk);
        System.out.println("beg mini : " + mini);
        Integer pop = stk.pop();
        if (mini.peek().intValue() == pop.intValue()) {
            mini.pop();
        }
        System.out.println("end stk : " + stk);
        System.out.println("end mini : " + mini);
        System.out.println("---------------------------");
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return mini.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
