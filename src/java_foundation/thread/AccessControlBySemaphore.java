package java_foundation.thread;

import java.util.concurrent.Semaphore;

/**
 * 通过信号量，来进行访问控制，限制并发量
 *
 * 信号量类可以限制对资源的并发访问数
 *
 * 信号量的基本原理比较简单，也是基于AQS实现的，permits表示共享的锁个数，
 * acquire方法就是检查锁个数是否大于0，大于则减一，获取成功，
 * 否则就等待，release就是将锁个数加一，唤醒第一个等待的线程。
 */
public class AccessControlBySemaphore {
    public static class ConcurrentLimitException extends RuntimeException {
        private static final long serialVersionUid = 1L;
    }
    private static final int MAX_PERMITS = 100;
    private Semaphore permits = new Semaphore(MAX_PERMITS, true);
    public boolean login(String name, String password) {
        if (! permits.tryAcquire()) { // 尝试获取许可
            throw new ConcurrentLimitException();
        }

        return true;
    }

    public void logout(String name) {
        permits.release(); // 释放许可
    }
}
