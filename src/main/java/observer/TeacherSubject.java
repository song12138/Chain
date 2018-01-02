package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2017/11/30.
 */
public class TeacherSubject implements Subject<Observer> {
    //用来存放和记录观察者
    private List<Observer> observers = new ArrayList<>();

    //记录状态的字符串
    private String info;

    @Override
    public void registObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> {
            observer.updata(info);
        });
    }


    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info){
        this.info=info;
        System.out.println("今天的作业是"+info);
        this.notifyObserver();
    }
}
