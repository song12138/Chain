package Iterator;

/** 定义具体迭代器角色(Concrete Iterator)
 * Created by paul on 2017/11/28.
 */
public class ConcreteIterator implements Iterator {
    private List list = null;
    private int index;


    public ConcreteIterator(List list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object o = list.get(index);
        index++;
        return o;
    }
}
