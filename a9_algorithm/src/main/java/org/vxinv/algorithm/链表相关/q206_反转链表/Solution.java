package org.vxinv.algorithm.链表相关.q206_反转链表;


import org.vxinv.algorithm.链表相关.util.ListNode;

/**
 * 遍历直接反向修改next指针 o(n)
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre  = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            temp = t;
        }
        return pre;
    }

}
