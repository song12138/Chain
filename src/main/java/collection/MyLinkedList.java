package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by paul on 2017/11/28.
 */
public class MyLinkedList<E> implements Iterable<E>{
    //数据的大小
    private int thsSize;
    //记录对链表改变的次数
    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        first = new Node<E>(null, null, null);
        last = new Node<E>(null, first, null);
        first.next = last;
        thsSize = 0;
        modCount++;
    }

    public int size() {
        return thsSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean add(E element) {
        add(size(), element);
        return true;
    }


    public void add(int idx, E element) {
        addBefore(getNode(idx), element);
    }

    private void addBefore(Node<E> node, E element) {
        Node<E> newNode = new Node<E>(element, node.prev, node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        thsSize++;
        modCount++;
    }

    public E get(int idx) {
        return getNode(idx).element;
    }

    public E set(int idx, E element) {
        Node<E> node = getNode(idx);
        E e = node.element;
        node.element = element;
        return e;
    }

    public E remove(int idx) {
        return remove(getNode(idx));
    }


    private E remove(Node<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        thsSize--;
        modCount++;
        return node.element;
    }


    private Node<E> getNode(int idx) {
        Node<E> node;
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        //从前到后遍历
        if (idx < size() / 2) {
            node = first.next;
            for (int i = 0; i < idx; i++) {
                node = node.next;
            }
        } else {
            //从后向前遍历
            node = last;
            for (int i = size(); i > idx; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private LinkedListIterator iterator;


    @Override
    public Iterator<E> iterator() {
        return iterator = new LinkedListIterator();
    }


    /**
     * 双向链表
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;

        public Node<E> prev;

        public Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current=first.next;

        //检测在迭代期间集合被修改
        private int exceptedModCount = modCount;
        //是否可以删除
        private boolean okToRemove = false;



        @Override
        public boolean hasNext() {
            return current != last;
        }

        @Override
        public E next() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.element;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            //不可以删除
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            exceptedModCount++;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }


}
