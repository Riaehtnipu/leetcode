
## 题目地址
[https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/](链表中倒数第k个节点)

## 题目描述

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 

示例：
```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```



## 解法
### 解法1
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 要清楚异常参数导致什么样的结果
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        // 第length - k + 1个
        int cnt = length - k;
        // 初始值length - k，最后0，说明执行length - k次
        while (cur != null && cnt > 0) {
            cnt--;
            cur = cur.next;
        }
        return cur;
    }
}
```


### 解法2
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 要清楚异常参数导致什么样的结果
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 正常情况是k > 0导致的终止
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        // 说明链表长度小于k
        if (k != 0) {
            return null;
        }

        // 会走k步，走到第k + 1个节点，剩余还会走len + 1 - (k + 1)步
        // 走到第1 + len - k个位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

