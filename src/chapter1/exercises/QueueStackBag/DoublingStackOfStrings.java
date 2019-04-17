package chapter1.exercises.QueueStackBag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class DoublingStackOfStrings<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1]; // 初始化栈
    private int N = 0;

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public void push(Item item)
    {
        if (N == a.length) resize( 2*a.length);
        a[N++] = item;
    }

    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;
        // 检测栈的大小是否小于数组的四分之一，是则长度减半
        if (N > 0 && N == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new DoublingStackIterator();
    }

    private class DoublingStackIterator implements Iterator<Item>
    {
        private int i = N;

        public boolean hasNext()
        {
            return i > 0;
        }

        public Item next()
        {
            return a[--i];
        }
    }

    public int arraySize(){
        return a.length;
    }

    public static void main(String[] args)
    {
        String[] str = args;
        DoublingStackOfStrings<String> stack = new DoublingStackOfStrings<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("-")) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }

            for (String s: stack) {
                StdOut.print(s + " ");
            }

            StdOut.println();
            StdOut.println("ArraySize: " + stack.arraySize());
            StdOut.println();
        }


    }
}
