package bridge;

/**
 * Created by paul on 2017/12/13.
 */
public class Test {
    public static void main(String[] args) {
        Itv tv = new SonyTV();
        AbstractRemoteControl remoteControl = new LogitechRemoteControl(tv);

        remoteControl.setChannel(10);

    }
}
