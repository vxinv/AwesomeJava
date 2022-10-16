package org.vxinv.algorithm.链表相关.q21_合并两个有序链表;

import org.vxinv.algorithm.链表相关.util.ListNode;

public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode nexth = head;
        ListNode pl1 = l1;
        ListNode pl2 = l2;
        while (pl2 != null && pl1 != null){
            if (pl1.val <= pl2.val){
                nexth.next = pl1;
                pl1 = pl1.next;
            }else {
                nexth.next = pl2;
                pl2 = pl2.next;
            }
            nexth = nexth.next;
        }
        if (pl1 == null){
            nexth.next = pl2;
        }else {
            nexth.next = pl1;
        }
        return head.next;
    }
}
