package leetcode.array;

import java.util.HashSet;

/**
 * 142. 环形链表 II
 * solution1: hashSet+枚举
 * solution2: 快慢指针
 */
public class LinkedListCycleII {
    private class ListNode {
        private int val;
        private ListNode next;
        ListNode(int v) {
            val = v;
            next = null;
        }
    }

    public ListNode Solution1(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        while (head != null) {
            if (map.contains(head)) {
                return head;
            } else {
                map.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public ListNode Solution2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
