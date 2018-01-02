package Lock.ReadWrite;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class ReadWriteLock2 {
    private Map<Thread, Integer> readingThreads = new HashMap<>();

    private int writeAccesses = 0;
    private int writeRequests = 0;


    private Thread writeThread = null;

    public synchronized void loclRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAcess(callingThread)) {
            wait();
        }
        readingThreads.put(callingThread, getReadAcessCount(callingThread));
    }

    public synchronized void unlockRead() throws InterruptedException{
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException(
                    "Calling Thread does not" +
                            " hold a read lock on this ReadWriteLock");
        }

        int accessCount = getReadAcessCount(callingThread);
        if (accessCount == 1) {
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, accessCount - 1);
        }
        notifyAll();
    }

    private boolean canGrantReadAcess(Thread callingThread) {
        if (isWriter(callingThread)) {
            return true;
        }
        if (writeThread != null) {
            return false;
        }
        if (isReader(callingThread)) {
            return true;
        }
        if (writeRequests > 0) {
            return false;
        }
        return true;
    }

    private boolean isReader(Thread callingThread) {
        return readingThreads.get(callingThread) != null;
    }

    private boolean isOnlyReader(Thread callingThread) {
        return readingThreads.size() == 1 && readingThreads.get(callingThread) != null;
    }

    private int getReadAcessCount(Thread callingThread) {
        Integer acessCount = readingThreads.get(callingThread);
        if (acessCount == null) {
            return 0;
        }
        return acessCount.intValue();
    }


    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        Thread callingThread = Thread.currentThread();
        while (!canGrantWritAcess(callingThread)) {
            wait();
        }
        writeRequests--;
        writeAccesses++;
        writeThread = callingThread;

    }

    public synchronized void unlockWrite() throws InterruptedException {
        if (!isWriter(Thread.currentThread())){
            throw new IllegalMonitorStateException(
                    "Calling Thread does not" +
                            " hold the write lock on this ReadWriteLock");
        }

        writeAccesses--;
        if (writeAccesses == 0) {
            writeThread = null;
        }
        notifyAll();
    }


    private boolean canGrantWritAcess(Thread callingThread) {
        if (isOnlyReader(callingThread)) {
            return true;
        }
        if (hasReaders()) {
            return false;
        }
        if (writeThread == null) {
            return true;
        }
        if (!isWriter(callingThread)) {
            return false;
        }
        return true;
    }

    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }

    private boolean isWriter(Thread callingThread) {
        return writeThread == callingThread;
    }


}
