package java_foundation.thread;

/**
 * 内存可见性
 *  计算机系统中，除了内存，数据还会被缓存到CPU的寄存器以及各级缓存中，当访问一个变量时，可能直接从寄存器或CPU缓存中获取
 *  而不一定到内存中取，当修改一个变量时，也可能时先写到缓存中，稍后在同步更新到内存中。
 *  多线程的程序中，尤其是多CPU的程序中，一个线程对内存的修改，另一个线程看不到，这是很严重的问题。
 *
 *  怎么解决呢？
 *  1. volatile 关键字
 *  2. syncchronized 关键字或显式锁同步
 */
public class VisibilityDemo {
    private static boolean shutdown = false;
    static class HelloThread extends Thread {
        @Override
        public void run() {
            while (! shutdown) {

            }
            // 这里可能永远不会执行
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }
}
