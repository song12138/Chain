package flyWeight;

/**   FlyWeight抽象享元类：通常是一个接口或抽象类，声明公共方法，这些方法可以向外界提供对象的内部状态，设置外部状态。
    UnsharedConcreteFlyWeight非共享享元类：不能被共享的子类可以设计为非共享享元类。
    ConcreteFlyWeight具体享元类：为内部状态提供成员变量进行存储。

    FlyWeightFactory享元工厂类：创建并管理享元对象，享元池一般设计为键值对。
 * Created by paul on 2017/11/24.
 */
public interface ChessFlyWeight {
    String getColor();//获取颜色，内部状态
    void display(Coordinate c);//展示位置，外部状态
}
