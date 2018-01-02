package bridge;

/** 遥控器要包含对TV的引用
 * Created by paul on 2017/12/13.
 */
public abstract class AbstractRemoteControl {

    private Itv tv;

    public AbstractRemoteControl(Itv tv) {
        this.tv = tv;
    }

    public void turnOn(){
        tv.on();
    }

    public void turnOff(){
        tv.off();
    }

    public void setChannel(int channel){
        tv.switchChannel(channel);
    }
}
