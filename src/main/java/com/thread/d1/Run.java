package com.thread.d1;

/**
 * Created by paul on 2017/12/11.
 */
public class Run {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();

            System.out.println("stop 1??" + thread.interrupted());
            System.out.println("stop 2??" + thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
