package com.thread.d1;

/**
 * Created by paul on 2017/12/11.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i=0; i<500000; i++){
            System.out.println("i="+(i+1));
        }
    }
}
