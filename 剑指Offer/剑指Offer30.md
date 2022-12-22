
## 题目地址
[包含min函数的栈](https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/)

## 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

 

示例:
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```
 

提示：

1.各函数的调用总次数不超过 20000 次



## 解法

### 解法1
```java
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

```


### 解法2
```java
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
        // 一直维护当前情况最小的
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException();
        }
        // 此题如果用==将会无法通过 Integer的equals重写过，比较的是内部value的值， 
        // ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
        if (stack1.pop().equals(stack2.peek())) {
            stack2.pop();
        }
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
```
