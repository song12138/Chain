package Threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** threadlocal 里面就是封装列一个map
 * Created by paul on 2017/12/11.
 */
public class MyThreadLocal<T> {
    //定义了一个同步的map
    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value) {
        container.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)) {
            value = null;
            container.put(thread, value);
        }
        return value;
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

}
