package org.vxinv.algorithm.多线程;



/**
 * @author lixin
 * @date 2021/5/31
 * @description:
 */
public class s2d {
    public static void main(String[] args) {
        int[] ints = new int[] { 1, 2, 3, 4 };
        int[] int2 = new int[4];
        int[] int3 = { 1, 2, 3, 4 };

        ListNode head = createListNode(ints);
        System.out.println(head);

        ListNode listNode = reversListNode(head);
        System.out.println(listNode);

    }

    /**
     * 反转列表
     * 
     * @param head
     * @return
     */
    public static ListNode reversListNode(ListNode head) {
        ListNode curr = null;
        ListNode pre = null;
        while (head != null) {
            pre = head.next;
            head.next = curr;
            curr = head;
            head = pre;
        }
        return curr;
    }

    /**
     * 生成单线链表
     * 
     * @param ints
     * @return
     */
    public static ListNode createListNode(int[] ints) {
        ListNode root = null;
        ListNode lastNode = null;
        for (int anInt : ints) {
            if (root == null) {
                root = new ListNode(anInt);
                lastNode = root;
                continue;
            }
            lastNode.next = new ListNode(anInt);
            lastNode = lastNode.next;
        }
        return root;
    }
}
