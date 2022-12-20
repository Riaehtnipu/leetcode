package algorithm.offer.q24;

import algorithm.offer.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     ListNode cur = head;
    //     ListNode pre = null;
    //     ListNode tmp = null;
    //     while (cur != null) {
    //         tmp = cur.next;
    //         cur.next = pre;
    //         pre = cur;
    //         cur = tmp;
    //     }
    //     return pre;
    // }

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }

    //     ListNode node = new ListNode(-1);

    //     ListNode cur = head;
    //     ListNode tmp = null;
    //     while (cur != null) {
    //         tmp = cur.next;
    //         cur.next = node.next;
    //         node.next = cur;
    //         cur = tmp;
    //     }
    //     return node.next;
    // }


    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     return reverse(head);
    // }

    // // 反转并返回头节点，最后一个节点置为null
    // ListNode reverse(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode res = reverse(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return res;
    // }

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }
    //     return reverse(head, null);
    // }

    // // 1.反转并返回头节点，最后一个节点置为null，并且当前链表的前驱是null（需要始终维护这个含义）
    // // 2.第二个参数相当于当前递归层级的一个全局变量
    // ListNode reverse(ListNode head, ListNode pre) {
    //     // 第二个判断防止npe
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     ListNode res = reverse(head.next, head);
    //     head.next.next = head;
    //     head.next = pre;
    //     return res;
    // }

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
