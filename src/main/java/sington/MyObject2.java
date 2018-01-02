package sington;

/** 使用静态内部类实现单例模式
 * Created by paul on 2017/12/5.
 */
public class MyObject2 {
    private static class MyObject2Handler{
        private static MyObject2 myObject2 = new MyObject2();
    }

    private MyObject2() {

    }

    public static MyObject2 getInstance(){
        return MyObject2Handler.myObject2;
    }

}
