package org.vxinv.algorithm.链表相关;

import org.vxinv.algorithm.链表相关.util.ListNode;

public class LinkedListEntryPoint {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
