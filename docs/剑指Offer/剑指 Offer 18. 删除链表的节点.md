
## 题目地址
[删除链表的节点](https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

## 题目描述
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:
```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

示例 2:
```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

 

说明：

* 题目保证链表中节点的值互不相同
* 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
	

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
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                // 说明是头节点
                if (pre == null) {
                    return head.next;
                }
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
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

    // 简化了写法
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 移出来
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        if (cur != null) {
           pre.next = cur.next;
        }
        return head;
    }


}
```

