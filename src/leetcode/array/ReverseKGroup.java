package leetcode.array;

/**
 *  K 个一组翻转链表
 *  solution1: 递归反转，1.先反转k个节点，然后再接着反转k个，直到反转完整个链表
 *                      2. 如果反转的链表，不足k个，则不需要反转
 */
public class ReverseKGroup {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solution1(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        // 判断是否够k个值，不足k个不需要反转
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b); //这里反转完成后, 就可以继续反转a后面的k个元素
        // 反转完成后,a已经到尾部了。
        a.next = solution1(b, k);
        return newHead;
    }

    // 哨兵法反转链表
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start, nxt;
        ListNode prev = null;
        while (curr != end) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
