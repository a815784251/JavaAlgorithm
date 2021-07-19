package coccurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 * @author JingHe
 * @date 2021-07-19 11:06
 */
public class ReplacePrint {

    final private Object lock = new Object();

    final private ReentrantLock reentrantLock = new ReentrantLock();
    Condition oddCondition = reentrantLock.newCondition();
    Condition evenCondition = reentrantLock.newCondition();

    private volatile Integer index = 0;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ReplacePrint print = new ReplacePrint();
//        pool.submit(print.new SynThread1());
//        pool.submit(print.new SynThread2());

        pool.submit(print.new LockThread1());
        pool.submit(print.new LockThread2());
        pool.shutdown();
    }

    public class SynThread1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        if (index % 2 == 0) {
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + "-----" + index++);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class SynThread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        if (index % 2 != 0) {
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + "-----" + index++);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class LockThread1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    if (index % 2 == 0) {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread().getName() + "-----" + index++);
                        oddCondition.signal();
                    } else {
                        evenCondition.await();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    public class LockThread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    if (index % 2 != 0) {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread().getName() + "-----" + index++);
                        evenCondition.signal();
                    } else {
                        oddCondition.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
}
