package Iterator;

/**
 * 定义具体容器角色(ConcreteList)
 * Created by paul on 2017/11/28.
 */
public class ConcreteList implements List {

    private Object[] list;

    private int size = 0;
    private int index = 0;


    public ConcreteList() {
        index =0;
        size = 0;
        list = new Object[100];

    }

    @Override
    public void add(Object object) {
        list[index++] = object;
        size++;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
