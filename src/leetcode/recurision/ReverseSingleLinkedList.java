package leetcode.recurision;

/**
 * 反转单链表
 *
 */
public class ReverseSingleLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head; // 当前结点的下一个结点指向当前结点
        head.next = null; // 当前结点的下一个结点指向Null
        return p;
    }
}
