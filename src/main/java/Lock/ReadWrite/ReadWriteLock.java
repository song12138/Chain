package Lock.ReadWrite;

/**
 * Created by paul on 2017/12/18.
 */
public class ReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequest = 0;

    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequest > 0) {
            wait();
        }
        readers++;
    }


    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }


    public synchronized void lockWrite() throws InterruptedException {
        writeRequest++;
        while (readers > 0 || writers > 0) {
            wait();
        }
        writeRequest--;
        writers++;
    }

    public synchronized void unloclWrite() {
        writers--;
        notifyAll();
    }

}
