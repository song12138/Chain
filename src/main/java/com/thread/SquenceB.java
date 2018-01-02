package com.thread;

/**
 * Created by paul on 2017/11/1.
 */
public class SquenceB implements Sequence {

    //线程安全
    private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }

        @Override
        public Integer get() {
            return super.get();
        }

        @Override
        public void set(Integer value) {
            super.set(value);
        }

        @Override
        public void remove() {
            super.remove();
        }
    };

    @Override
    public Integer getNumber() {
        numberContainer.set(numberContainer.get() + 1);
        return numberContainer.get();
    }


    public static void main(String [] args){
        Sequence sequence = new SquenceB();
        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
