package chapter1.exercises.QueueStackBag;

/**
 * 1.3.1 为FixedCapacityStackOfStrings 添加一个方法isFull()
 */
public class Ex131
{
    public class FixedCapcityStack<Item>
    {
        private Item[] a;
        private int N;

        public FixedCapcityStack(int cap)
        {
            a = (Item[]) new Object[cap];
        }

        public boolean isEmpty()
        {
            return N == 0;
        }

        public boolean isFull()
        {
            return N == a.length;
        }

        public void push(Item item)
        {
            a[N++] = item;
        }
    }
}
