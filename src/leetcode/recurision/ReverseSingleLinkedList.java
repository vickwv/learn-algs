package leetcode.recurision;

/**
 * 反转单链表
 * solution1: 纯粹递归反转
 * solution2: 迭代反转
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

    /**
     * 5->null
     * 5->4->null
     * 5->4->3->null
     * @param head
     * @return
     */
    public ListNode Solution1(ListNode head)
    {
        // 假设有个单链表 1->2->3->4->5,当前curr=5,则head=4.
        if (head == null || head.next == null) return head;
        ListNode curr = Solution1(head.next);
        // 这里把5->4->null
        head.next.next = head; // 当前结点的下一个结点指向当前结点
        head.next = null; // 当前结点的下一个结点指向Null
        return curr;
    }

    public ListNode Solution2(ListNode head)
    {
        ListNode prev = null; // 用来存储已经反转的节点
        ListNode current = head; // 用来存储下一个节点
        while (current != null ) {
            ListNode tmp = current.next; // 因为current.next->prev，所以要先存储Next节点
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
