package org.vxinv.algorithm.链表相关.q19_删除链表的倒数第N个节点.my1;

import org.junit.jupiter.api.Test;
import org.vxinv.algorithm.链表相关.util.ListNode;
import org.vxinv.algorithm.链表相关.util.ListUtil;


/**
 * 利用两个指针 o(n)
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode point = head;
        // 求出长度
        while (point != null) {
            i++;
            point = point.next;
        }
        // 求出到哪里停止
        int b = i - n; //2
        if (b == 0) {
            return head.next;
        }
        point = head;
        for (int k = 0; k < b-1; k++) {
            point = point.next;
            // 0 -- 0 -- 0-- 0
        }
        point.next = point.next.next;
        return head;
    }

    @Test
    public void test01() {
        ListNode head = ListUtil.buildList(1, 2, 6, 3, 4, 5, 6);
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    @Test
    public void test02() {
        ListNode head = ListUtil.buildList(1, 2);
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
