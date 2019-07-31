package leetcode.recurision;

import edu.princeton.cs.algs4.StdOut;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。(必须交换结点，而不是交换内部的值)
 * 示例：
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    private ListNode first;

    private class ListNode {
        private int val;
        private ListNode next;
        ListNode(int v) { val = v; }
    }

    public SwapPairs() {
        first = null;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head, p2 = head.next, p3 = p2.next;
        p1.next = p3;
        p2.next = p1;

        if (p3 != null) {
            p1.next = swapPairs(p3);
        }
        return p2;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next); // node1 要指向下两个结点交换后的头结点，递归获取
        next.next = head; // 假设 head为node1, next = head.next 为node2，这里是 node2->node1，交换结点
        return next;
    }


    public void add(int v) {
        ListNode temp = new ListNode(v);
        temp.next = first;
        first = temp;
    }

    public void printNode() {
        while (first != null) {
            StdOut.println(first.val);
            first = first.next;
        }
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        for (int i = 4; i >= 1; i--) {
            swapPairs.add(i);
        }
        swapPairs.swapPairs(swapPairs.first);
        swapPairs.printNode();
    }
}
