package java_foundation.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static AtomicInteger counter = new AtomicInteger(0);

    static class Vistor extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Vistor();
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
