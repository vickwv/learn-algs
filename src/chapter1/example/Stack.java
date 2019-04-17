package chapter1.example;

import java.util.Iterator;
// 使用链表实现 stack
public class Stack<Item> implements Iterable<Item>
{
    private Node first;
    private int N;
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

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return null;
    }
}
