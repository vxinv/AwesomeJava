package org.vxinv.algorithm.链表相关;



/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. 环形链表</a>
 * @since 2020-06-09
 */
/*
public class CircularLinkedList {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(3, 2, 0, -4);
        Assertions.assertFalse(hasCycle(head));

        head = ListUtil.buildCycleList(1, new int[] { 3, 2, 0, -4 });
        Assertions.assertTrue(hasCycle(head));

        head = ListUtil.buildCycleList(0, new int[] { 1, 2 });
        Assertions.assertTrue(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head.next;
        // 快慢指针不停在环上走 如果相遇就是环
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
*/
