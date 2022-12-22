
## 题目地址
[从尾到头打印链表](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

## 题目描述

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：
```
输入：head = [1,3,2]
输出：[2,3,1]
```
 

限制：

0 <= 链表长度 <= 10000


## 解法
### 解法1
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

     public int[] reversePrint(ListNode head) {
         if (head == null) {
             return new int[0];
         }
         Stack<Integer> stack = new Stack<>();
         while (head != null) {
             stack.push(head.val);
             head = head.next;
         }
         int[] res = new int[stack.size()];
         for (int i = 0; i< res.length; i++) {
             res[i] = stack.pop();
         }
         return res;
     }

}
```

### 解法2
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        reverse(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i< res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void reverse(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        reverse(head.next, list);
        list.add(head.val);
    }
}
```
