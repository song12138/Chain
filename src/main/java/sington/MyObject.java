package sington;

/**
 * Created by paul on 2017/12/5.
 */
public class MyObject {

    private volatile static MyObject myObject;

    private MyObject() {

    }

    //使用DCL双检查锁，既保证不需要同步代码的异步执行性，又保证了单例的效果
    //双检查锁就是在同步代码块调用之前检查一遍，载再在同步代码块内部再检查一遍。双重保险
    public static MyObject getInstance(){
        try {
            if (myObject == null) {
                //模拟创建之前的准备工作
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (myObject == null) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
        }
        return myObject;
    }
}
