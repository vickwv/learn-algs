package chapter1.exercises.QueueStackBag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.7 为 Stack 添加一个方法 peek, 返回栈中最近添加的元素
 * @param <Item>
 */
public class PeekStack<Item> implements Iterable<Item>
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

    /**
     * 返回栈中最近添加的元素
     * @return
     */
    public Item peek()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("not found this element");
        } else {
            return first.item;
        }
    }
}
