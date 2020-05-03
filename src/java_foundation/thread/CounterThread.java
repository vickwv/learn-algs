package java_foundation.thread;

/**
 * 竞争条件示例
 * 多个线程访问和操作一个对象时，最终执行的结果与执行时序有关
 */
public class CounterThread extends Thread {
    public static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter); // 每次输出的结果都不一样，因为count++不是原子操作。 怎么解决这个问题
        /**
         * 1. 使用syncchronized 关键字
         * 2. 使用显示锁
         * 3. 使用原子变量
         */
    }
}
