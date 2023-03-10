
## 题目地址
[反转链表](https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/)

## 题目描述
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```
 

限制：

0 <= 节点个数 <= 5000



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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = new ListNode(-1);

        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = tmp;
        }
        return node.next;
    }

}
```


### 解法3
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
   
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head);
    }

    // 反转并返回头节点，最后一个节点置为null
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

}
```

### 解法4
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

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    // 1.反转并返回头节点，最后一个节点置为null，并且当前链表的前驱是null（需要始终维护这个含义）
    // 2.第二个参数相当于当前递归层级的一个全局变量
    ListNode reverse(ListNode head, ListNode pre) {
        // 第二个判断防止npe
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverse(head.next, head);
        head.next.next = head;
        head.next = pre;
        return res;
    }

}
```

### 解法5
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
 
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head, null);
    }

    // 1.反转并返回头节点，最后一个节点置为pre
    // 2.第二个参数相当于当前递归层级的一个全局变量
    ListNode reverse(ListNode head, ListNode pre) {
        // 可以继续往下拆一层
        if (head.next == null) {
            head.next = pre;
            return head;
        }

        ListNode res = reverse(head.next, head);
        head.next = pre;
        return res;
    }

}
```