package java8.inter;

/** Java 8能够传递一个方法或者构造器引用通过 ::关键字. 上面的实例向你们展示了怎么去引用一个静态方法. 我们也能够引用一个普通对象方法:
 * Created by paul on 2017/12/18.
 */
public class Something {
    static String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
