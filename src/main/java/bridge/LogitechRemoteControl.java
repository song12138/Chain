package bridge;

/**
 * Created by paul on 2017/12/13.
 */
public class LogitechRemoteControl extends AbstractRemoteControl {
    public LogitechRemoteControl(Itv tv) {
        super(tv);
    }

    @Override
    public void setChannel(int channel) {
        super.setChannel(channel);
        System.out.println("遥控器调台");
    }
}
