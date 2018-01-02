package producerandcustomer;

/**
 * Created by paul on 2017/11/14.
 */
public class Producer extends Thread {

    // 每次生产的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    // 构造函数，设置仓库
    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void produce(int num){
        storage.produce(num);
    }


    @Override
    public void run() {
       produce(num);
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
