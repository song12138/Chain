package toaster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by paul on 2017/11/22.
 */
public class ToastTest {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), finishedQueue = new ToastQueue();

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));

        TimeUnit.SECONDS.sleep(5);

        exec.shutdownNow();
    }
}
