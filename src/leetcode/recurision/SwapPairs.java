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

    /**
     * 迭代法
     * 1. 新增一个prev节点，作为前驱节点，指向head
     * 2. 交换奇偶两个节点
     * 3. Prev指向交换过后的head
     * @param head
     * @return
     */
    public ListNode Solution1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy; // prev节点作为前驱节点，用于两两交换
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /**
     * 递归法
     * @param head ListNode
     */
    public ListNode Solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // firstNode.next 要先交换下两个节点。也就是每次递归都交换两个节点
        firstNode.next = Solution2(secondNode.next);
        secondNode.next = firstNode;
        // 交换成功后 secondNode 就是新的head
        return secondNode;
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
        swapPairs.Solution1(swapPairs.first);
        swapPairs.printNode();
    }
}
