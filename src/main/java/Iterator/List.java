package Iterator;

/** 定义容器角色(Aggregate)
 * Created by paul on 2017/11/28.
 */
public interface List {
    public void add(Object object);

    public Object get(int index);

    public Iterator iterator();

    public int getSize();

}
