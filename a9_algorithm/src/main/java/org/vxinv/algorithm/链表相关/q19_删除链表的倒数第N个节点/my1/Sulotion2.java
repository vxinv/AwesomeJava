package org.vxinv.algorithm.链表相关.q19_删除链表的倒数第N个节点.my1;

import org.junit.jupiter.api.Test;
import org.vxinv.algorithm.链表相关.util.ListNode;
import org.vxinv.algorithm.链表相关.util.ListUtil;


public class Sulotion2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i = 0;
        while (temp != null){
            i++;
            temp = temp.next;
        }
        // 双指针
        int f  = i - n;
        i = 1;
        temp = head;
        while (i < f){
            i++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    @Test
    public void test01(){
        ListNode head = ListUtil.buildList(1, 2, 6, 3, 4, 5, 6);
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
