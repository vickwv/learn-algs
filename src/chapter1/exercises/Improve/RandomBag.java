package chapter1.exercises.Improve;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private int n;
    private Item[] bag;

    public RandomBag(int max) {
        this.bag = (Item[]) new Object[max];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        bag[n++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {
        public RandomBagIterator() {
            shuffle(bag);
        }

        /**
         * 随机排序
         * @param b
         */
        public void shuffle(Item b[]) {
            int N = b.length;

            for (int i = 0; i < N; i++) {
                int r = i + (int)(Math.random() * (N-i)); // 随机排序的关键点
                Item temp = b[i];
                b[i] = b[r];
                b[r] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            return bag[--n];
        }
    }
}
