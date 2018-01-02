package producerandcustomer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者模型：当队列满时，生产者需要等待队列有空间才能继续往里面放入商品，而在等待的期间内，
 * 生产者必须释放对临界资源（即队列）的占用权。因为生产者如果不释放对临界资源的占用权，
 * 那么消费者就无法消费队列中的商品，就不会让队列有空间，那么生产者就会一直无限等待下去。
 * 因此，一般情况下，当队列满时，会让生产者交出对临界资源的占用权，并进入挂起状态。
 * 然后等待消费者消费了商品，然后消费者通知生产者队列有空间了。
 * 同样地，当队列空时，消费者也必须等待，等待生产者通知它队列中有商品了。这种互相通信的过程就是线程间的协作。
 * <p>
 * Created by paul on 2017/11/14.
 */
public class Storage2 extends Storage{
    //仓库最大容量
    private static final int MAX_SIZE = 100;

    //仓库载体
    private LinkedList<Object> list = new LinkedList<>();

    //锁
    private final Lock lock = new ReentrantLock();

    //仓库满的条件变量
    private final Condition full = lock.newCondition();
    //仓库空的条件变量
    private final Condition empty = lock.newCondition();


    public static int getMaxSize() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    @Override
    public void produce(int num) {

            // 获得锁
            lock.lock();

            while (list.size() + num > MAX_SIZE) {
                System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:"
                        + list.size() + "/t暂时不能执行生产任务!");
                try {
                    // 由于条件不满足，生产阻塞
                   full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产条件满足情况下，生产num个产品
            for (int i = 1; i <= num; ++i) {
                list.add(new Object());
            }

            System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());

            //唤醒其他线程
            full.signalAll();
            empty.signalAll();

            //释放锁
            lock.unlock();
    }


    // 消费num个产品
    @Override
    public void consume(int num) {
        // 获得锁
        lock.lock();
            // 如果仓库存储量不足
            while (list.size() < num) {
                System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:"
                        + list.size() + "/t暂时不能执行消费任务!");
                try {
                    // 由于条件不满足，消费阻塞
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 消费条件满足情况下，消费num个产品
            for (int i = 1; i <= num; ++i) {
                list.remove();
            }

            System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());

            empty.signalAll();
            full.signalAll();

            //释放锁
            lock.unlock();
    }

}
