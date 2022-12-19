package algorithm.offer.q30;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException();
        }
        stack2.pop();
        stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            throw new RuntimeException();
        }
        return stack1.peek();
    }

    public int min() {
        if (stack2.isEmpty()) {
            throw new RuntimeException();
        }
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

//class MinStack {
//
//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack1.push(x);
//        // 一直维护当前情况最小的
//        if (stack2.isEmpty() || x <= stack2.peek()) {
//            stack2.push(x);
//        }
//    }
//
//    public void pop() {
//        if (stack1.isEmpty()) {
//            throw new RuntimeException();
//        }
//        // 此题如果用==将会无法通过 Integer的equals重写过，比较的是内部value的值，
//        // ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
//        if (stack1.pop().equals(stack2.peek())) {
//            stack2.pop();
//        }
//    }
//
//    public int top() {
//        if (stack1.isEmpty()) {
//            throw new RuntimeException();
//        }
//        return stack1.peek();
//    }
//
//    public int min() {
//        if (stack2.isEmpty()) {
//            throw new RuntimeException();
//        }
//        return stack2.peek();
//    }
//}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
