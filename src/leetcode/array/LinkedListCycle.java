package leetcode.array;


import java.util.HashSet;

/**
 * 链表中是否有环
 * solution1: hashmap+枚举。遍历整个链表，每次遍历都把当前节点存在hashmap,并判断当前节点是否存在链表，如果存在就说明链表有环
 * solution2: 快慢指针法
 */
public class LinkedListCycle {
    private class ListNode {
        private int val;
        private ListNode next;
        ListNode(int v) {
            val = v;
            next = null;
        }
    }

    public boolean solution1(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        while (head != null) {
            if (map.contains(head)) {
                return true;
            } else {
                map.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
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
