package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by paul on 2017/11/28.
 */
public class MyArraylist<E> implements Iterable<E> {
    //默认大小
    private static final int DEFAULT_CAPACITY = 10;
    //元素指针位置，就是当前元素的size
    private int theSize;
    // thtItems.size() 为当前容器的大小
    private E[] theItems;

    public MyArraylist() {
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        //扩容大小小于当前的元素指针位置，说明当前不需要扩容
        if (newCapacity < theSize) {
            return;
        }
        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];
        for (int i= 0;i<size();i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }


    public void add(int idx, E x) {
        //当相等时，说明元素的指针到最后一个，需要扩容
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        //将插入位置的后置位元素向右移动一位
        for (int i=theSize;i>idx;i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public E remove(int idx) {
        E removeItem = theItems[idx];
        //将删除位置的后置位元素向左移动一位
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removeItem;
    }

    private ArrayListIterator arrayListIterator;
    @Override
    public Iterator<E> iterator() {
        return arrayListIterator = new ArrayListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }


    private class ArrayListIterator implements Iterator<E> {

        private int current = 0;


        @Override
        public boolean hasNext() {
            return current < MyArraylist.this.size();
        }

        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }else {
                return theItems[current++];
            }
        }

        @Override
        public void remove() {
            MyArraylist.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

}
