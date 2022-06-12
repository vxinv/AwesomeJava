package org.vxinv.algorithm.链表相关.q2_两数相加;

import org.junit.Test;

// 简单题 想的太复杂
public class Solution03 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode k1 = revers(l1);
        ListNode k2 = revers(l2);
        ListNode he = null;
        ListNode tem = null;
        ListNode p1 = k1;
        ListNode p2 = k2;
        int fw = 0; // 进位 上一个和大于10 fw=1
        while (p1 != null || p2 != null || fw != 0) {
            int h = fw;
            fw = 0; //进位值0
            if (p1 != null) {
                h += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                h += p2.val;
                p2 = p2.next;
            }
            if (he == null) {
                if (h >= 10) {
                    tem  = new ListNode(h % 10);
                    fw = 1;
                } else {
                    tem = new ListNode(h);
                }
                he = tem;
                continue;
            } else {
                if (h >= 10) {
                    tem.next = new ListNode(h % 10);
                    fw = 1;
                } else {
                    tem.next = new ListNode(h);
                }
                tem = tem.next;
            }
        }
        return he;
    }

    // 反转链表
    public ListNode revers(ListNode ll) {
        ListNode last = null;
        ListNode nextNode = ll;
        while (nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = last;
            last = nextNode;
            nextNode = temp;
        }
        return last;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test01() {
        int[] l1 = {9,9,9,9,9,9,9};
        int[] l2 = {9,9,9,9};
        ListNode n1 = null;
        ListNode cn1 = null;
        ListNode n2 = null;
        ListNode cn2 = null;
        for (int i = 0; i < l1.length; i++) {
            if (i == 0) {
                n1 = new ListNode(l1[i]);
                cn1 = n1;
                continue;
            }
            ListNode tem = new ListNode(l1[i]);
            n1.next = tem;
            n1 = tem;
        }
        for (int i = 0; i < l2.length; i++) {
            if (i == 0) {
                n2 = new ListNode(l2[i]);
                cn2 = n2;
                continue;
            }
            ListNode tem = new ListNode(l2[i]);
            n2.next = tem;
            n2 = tem;
        }

        ListNode listNode = addTwoNumbers(cn1, cn2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
