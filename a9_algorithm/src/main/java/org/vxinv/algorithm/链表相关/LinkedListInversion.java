package org.vxinv.algorithm.链表相关;

import org.vxinv.algorithm.链表相关.util.ListNode;
import org.vxinv.algorithm.链表相关.util.ListUtil;

class Linked_list_inversion {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(1, 2, 3, 4);
        System.out.println(ListUtil.toList(head));
        ListNode result = reverseList2(head);
        System.out.println(ListUtil.toList(result));
    }

    public static ListNode reverseList2(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = null;
        ListNode curr = head;

        //  a <- b <- c
        while (curr != null) {
            // 下一个节点
            ListNode tem = curr.next;
            // 连接上一个节点
            curr.next = pre;
            // 当前节点作为下一次的上一个节点
            pre = curr;
            // 下一次找到下一个节点
            curr = tem;
        }
        return pre;
    }
}
