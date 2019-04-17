package chapter1.example;

import java.util.Iterator;
// 使用链表实现队列
public class Queue<Item> implements Iterable<Item>
{
    private int N;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private Node first;
    private Node last;
    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }


    public void enqueue(Item item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

}
