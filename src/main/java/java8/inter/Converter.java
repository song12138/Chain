package java8.inter;

/** 函数接口化
 * 我们能够使用任意接口作为lambda表达式,这个接口中只需要包含一个抽象的方法就可以了. 为了确保你的接口
 * 满足需求，你需要在你接口上添加一个@FunctionalInterface注解.当你使用这个注解之后，这个接口只能定义一个抽象方法，否者编译器会报错 .
 * Created by paul on 2017/12/18.
 */
@FunctionalInterface
public interface Converter<F, T> {

    T convert(F form);
}
