package toaster;

/**
 * Created by paul on 2017/11/22.
 */
public class Eater implements Runnable {

    private ToastQueue finshedQueue;

    private int counter = 0;

    public Eater(ToastQueue finshedQueue) {
        this.finshedQueue = finshedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finshedQueue.take();
                if (t.getId() != counter++
                        || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off吃完");
    }



}
