package org.vxinv.algorithm.链表相关.util;

import java.util.Objects;

public  class ListNode {

    public  int val;
    public ListNode next;

    public  ListNode(int val) { this.val = val; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
            Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

}
