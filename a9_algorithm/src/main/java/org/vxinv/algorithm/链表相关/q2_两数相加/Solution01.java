package org.vxinv.algorithm.链表相关.q2_两数相加;

import org.junit.jupiter.api.Test;
import org.vxinv.algorithm.链表相关.util.ListNode;
import org.vxinv.algorithm.链表相关.util.ListUtil;


public class Solution01 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tl1 = l1;
        ListNode tl2 = l2;
        ListNode head = new ListNode(-1);
        ListNode tmpNode = null;
        // 如果前一步＞10 为1或0
        int lastStep = 0;
        // 两个链表
        while (tl1 != null || tl2 != null || lastStep != 0) {
            int a = 0;
            int b = 0;
            if (tl1 != null) {
                a = tl1.val;
                tl1 = tl1.next;
            }
            if (tl2 != null) {
                b = tl2.val;
                tl2 = tl2.next;
            }
            int c = a + b + lastStep;
            lastStep = 0;
            ListNode node = new ListNode(c % 10);
            if (c > 10) {
                lastStep = 1;
            }
            if (tmpNode == null) {
                tmpNode = node;
                head.next = tmpNode;
            } else {
                tmpNode.next = node;
                tmpNode = node;
            }
        }
        return head.next;
    }

    @Test
    public void test01() {
        ListNode listNode1 = ListUtil.buildList(1, 4, 9, 8, 5);
        ListNode listNode2 = ListUtil.buildList(4, 3, 5, 3, 6);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
