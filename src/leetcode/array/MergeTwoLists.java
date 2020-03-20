package leetcode.array;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {
    private static class ListNode {
        private int val;
        private ListNode next;
        ListNode(int v) { val = v; }
    }

    /**
     * 哨兵法
     * @param l1
     * @param l2
     * @return
     */
    private ListNode Solution1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 递归终止条件：l1或l2为null，则返回
     * @param l1
     * @param l2
     * @return
     */
    private ListNode Solution2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next =  Solution2(l1.next, l2);
            return l1;
        } else {
            l2.next = Solution2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoLists m = new MergeTwoLists();
        m.Solution1(l1, l2);
    }
}
