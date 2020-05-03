package java_foundation.thread;

/**
 * synchronized 实例方法实际保护的是同一个对象的方法调用，确保同时只能有一个线程执行
 * 具体来说保护的是当前实例对象，不是代码，即this，this对象有一个锁和一个等待队列，锁只能被一个线程持有，其他获取锁的线程需要等待。
 * 过程如下：
 *  1. 尝试获取锁，如果能获得锁，继续下一步，否则加入等待对垒，阻塞并等待唤醒
 *  2. 执行实例方法体代码
 *  3. 释放锁，如果等待队列上有等待的线程，从中取一个并唤醒，如果有多个等待的线程，唤醒哪一个是不一定的，不保证公平性。
 *
 *  一般保护变量时，需要在所有访问该变量的方法上加上synchronized
 *
 */
public class SynchronizedCounterThread extends Thread {
    private static class Counter {
        private int count;

        // 加了synchronized后, count++ 成为了原子操作
        public synchronized void incr() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    Counter counter;

    public SynchronizedCounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) counter.incr();
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new SynchronizedCounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount()); // 10000000
    }
}
