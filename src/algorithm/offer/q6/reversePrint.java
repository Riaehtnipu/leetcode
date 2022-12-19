package algorithm.offer.q6;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // public int[] reversePrint(ListNode head) {
    //     if (head == null) {
    //         return new int[0];
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     while (head != null) {
    //         stack.push(head.val);
    //         head = head.next;
    //     }
    //     int[] res = new int[stack.size()];
    //     for (int i = 0; i< res.length; i++) {
    //         res[i] = stack.pop();
    //     }
    //     return res;
    // }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();

        reverse(head, list);

        int[] res = new int[list.size()];
        for (int i = 0; i< res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void reverse(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        reverse(head.next, list);
        list.add(head.val);
    }
}
