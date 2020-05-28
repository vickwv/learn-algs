package java_foundation.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁实现一个缓存类MyCache
 *
 *  读写锁实现思路：
 *  内部，它们使用同一个整数变量表示锁的状态，16位给读锁用，16位给写锁用，使用一个变量便于进行CAS操作，锁的等待队列其实也只有一个。
 *  写锁的获取，就是确保当前没有其他线程持有任何锁，否则就等待。写锁释放后，也就是将等待队列中的第一个线程唤醒，唤醒的可能是等待读锁的，也可能是等待写锁的。
 *  读锁的获取不太一样，首先，只要写锁没有被持有，就可以获取到读锁，此外，在获取到读锁后，它会检查等待队列，逐个唤醒最前面的等待读锁的线程，直到第一个等待写锁的线程。
 *  如果有其他线程持有写锁，获取读锁会等待。读锁释放后，检查读锁和写锁数是否都变为了0，如果是，唤醒等待队列中的下一个线程。
 */
public class MyCacheByReadWriteLock {
    private Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Object put(String key, Object value) {
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
