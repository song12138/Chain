package toaster;

/**
 * Created by paul on 2017/11/22.
 */
public class Butterer implements Runnable {

    private ToastQueue dryQueue, butteredQueud;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueud) {
        this.dryQueue = dryQueue;
        this.butteredQueud = butteredQueud;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueud.put(toast);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off涂好土司");
    }
}
