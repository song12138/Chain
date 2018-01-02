package producerandcustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * Created by paul on 2017/11/14.
 */
public class Test {

    public static void main(String [] args){
//        Storage storage = new Storage();
        Storage storage = new Storage2();
        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Customer c1 = new Customer(storage);
        Customer c2 = new Customer(storage);
        Customer c3 = new Customer(storage);

        p1.setNum(20);
        p2.setNum(20);
        p3.setNum(20);
        p4.setNum(20);
        p5.setNum(20);
        p6.setNum(20);
        p7.setNum(20);
        c1.setNum(20);
        c2.setNum(20);
        c3.setNum(20);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        c1.start();
        c2.start();
        c3.start();


    }
}
