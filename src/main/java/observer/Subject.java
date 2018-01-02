package observer;

/**
 * Created by paul on 2017/11/30.
 */
public interface Subject<T> {

    void registObserver(T t);

    void removeObserver(T t);

    void notifyObserver();

}
