package com.thread_;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class ThreadSellTickets {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        Thread thread3 = new Thread(counter);


        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter implements Runnable {

    AtomicInteger ticketsNum = new AtomicInteger(10000);

    @Override
    public void run() {
        while (true) {
            if (ticketsNum.get() <= 0) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + " 票数是 > " + (ticketsNum.addAndGet(-1)));

            /*try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}
