package toaster;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by paul on 2017/11/22.
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;

    private int count = 0;

    private Random ran = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MICROSECONDS.sleep(100 + ran.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off烤好土司");
    }
}
