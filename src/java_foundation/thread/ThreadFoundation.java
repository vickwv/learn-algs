package java_foundation.thread;

public class ThreadFoundation extends Thread {
    @Override
    public void run() {
        System.out.println("thread name:" + Thread.currentThread().getName());
        System.out.println("Hello Thread");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFoundation threadFoundation = new ThreadFoundation();
        threadFoundation.start(); // java调用线程使用start()，start表示启动该线程，使其成为一条单独的执行流。
        //threadFoundation.run(); // 直接调用run方法，依然是在main线程执行的，此时只是一个普通的方法，没有启动一条单独的执行流。
        threadFoundation.join(); // 主线程等待子线程完成
    }
}
