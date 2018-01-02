package template;

/**
 * Created by paul on 2017/11/22.
 */
public abstract class AbstractClass {
    //基本方法
    protected abstract void doSomething();

    protected abstract void doAnything();

    //模板方法
    public void templateMethod(){
        //调用基本方法，完成相关逻辑
        this.doAnything();
        this.doSomething();
    }

}
