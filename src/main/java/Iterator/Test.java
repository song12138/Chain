package Iterator;

/**
 * Created by paul on 2017/11/28.
 */
public class Test {
    public static void main(String[] args) {
        List list = new ConcreteList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator iterator = new ConcreteIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
