package com.thread;

/**
 * Created by paul on 2017/11/1.
 */
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + "********" + sequence.getNumber());
        }
    }
}
