package java8.inter;

/** default 关键字
 * Created by paul on 2017/12/18.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
