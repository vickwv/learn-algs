package leetcode.array;

public class PartitionList {

    private static class ListNode {
        private int val;
        private ListNode next;
        ListNode(int v) { val = v; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);
        ListNode p1 = d1;
        ListNode p2 = d2;
        ListNode h = head;
        while(h != null) {
            if (h.val < x) {
                p1.next = h;
                p1 = p1.next;
            } else {
                p2.next = h;
                p2 = p2.next;
            }
            ListNode tmp = h.next;
            h.next = null;
            h = tmp;
        }
        p1.next = d2.next;
        return d1.next;
    }
}
