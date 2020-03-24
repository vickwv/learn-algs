package chapter1.example;

import java.util.Iterator;
// 使用链表实现背包
public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private class Node
    {
        Item item;
        Node Next;
    }

    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.Next = oldfirst;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.Next;
            return item;
        }
    }
}
