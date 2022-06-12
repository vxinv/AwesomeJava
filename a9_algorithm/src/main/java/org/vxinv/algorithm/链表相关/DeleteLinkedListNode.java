package org.vxinv.algorithm.链表相关;


import org.vxinv.algorithm.链表相关.util.ListNode;
import org.vxinv.algorithm.链表相关.util.ListUtil;

import java.util.List;

public class DeleteLinkedListNode {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 6, 3, 4, 5, 6);
        System.out.println(ListUtil.toList(head));
        ListNode result = removeElementByValue(head, 6);
        List<Integer> list = ListUtil.toList(result);
        System.out.println(list);

    }

    public static ListNode removeElementByValue(ListNode head, int val){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (dummy.next != null){
            ListNode cur = dummy.next;
            if (cur.val == val){
                if (dummy.next.next !=  null){
                    dummy.next =  dummy.next.next;
                }else {
                    dummy.next = null;
                    return head;
                }
            }
            dummy = dummy.next;
        }
        return null;
    }
}
