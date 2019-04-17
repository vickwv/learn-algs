package chapter1.exercises.Improve;

import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a;
    private int N = 0;
    private int first = 0;
    private int last = 0;

    public ResizingArrayDeque() {
        this.a = (Item[]) new Object[2];
    }

    protected boolean isEmpty() {
        return this.N == 0;
    }

    protected int size() {
        return this.N;
    }

    protected void resize(int capacity) {
        assert capacity >= this.N;
        Item[] temp = (Item[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            temp[i] = this.a[(this.first + i) % this.a.length];
        }

        this.a = temp;
        this.first = 0;
        this.last = N;
    }

    public void pushLeft(Item item) {
        if (this.N == this.a.length) {
            resize(2 * this.a.length);
        }

        if (this.first == 0) {
            this.first = this.a.length - 1;
            this.a[this.first] = item;
        } else {
            this.first--;
            this.a[this.first] = item;
        }
        this.N++;
    }

    public void pushRight(Item item) {
        if (this.N == this.a.length) {
            resize(2 * this.a.length);
        }

        this.a[this.last++] = item;
        if (this.last == this.a.length) {
            this.last = 0;
        }
        this.N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        Item firstEle = this.a[this.first];
        this.a[this.first] = null;
        this.N--;
        this.first++;
        if (this.first == this.a.length) this.first = 0;
        if (this.N > 0 && this.N == this.a.length/4) {
            resize(this.a.length/2);
        }

        return firstEle;
    }

    public Item popRight() {
        if (this.isEmpty()) {
            return null;
        }

        Item lastEle = this.a[this.last];
        if (this.last == 0) {
            this.last = this.a.length-1;
        } else {
            this.last--;
        }

        this.N--;
        if (this.N > 0 && this.N == this.a.length/4) {
            resize(this.a.length/2);
        }

        return lastEle;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Queue = ");
        for (int i = 0; i < this.N; i++) {
            sb.append((this.a[(this.first + i) % this.a.length]) + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> Ds = new ResizingArrayDeque<>();
        Ds.pushLeft("Hello");
        System.out.println("One Push Left - " + Ds.toString());
        Ds.pushRight("KevinRight1");
        Ds.pushLeft("KevinLeft1");
        Ds.pushLeft("KevinLeft2");
        Ds.pushRight("KevinRight2");
        System.out.println("Pushes Lt/Rt - " + Ds.toString());
        Ds.popLeft();
        System.out.println("Popped Left - " + Ds.toString());
        Ds.popRight();
        System.out.println("Pop Right - " + Ds.toString());
        Ds.pushRight("KevinRight2");
        System.out.println("Push Right - " + Ds.toString() + "\nStack Size: " + Ds.size());
        Ds.popLeft();
        Ds.popLeft();
        Ds.popRight();
        Ds.popRight();
        System.out.println("Popping until empty: " + Ds.toString());
        //Ds.popLeft();  // Uncomment for error messages.
    }
}
