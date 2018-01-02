package java8.inter;

/**
 * Created by paul on 2017/12/18.
 */
public interface PersonFactory<P extends Person> {
    P creat(String firstName,String lastName);
}
