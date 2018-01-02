package collection;

import sun.security.util.Length;

/**
 * Created by paul on 2017/11/29.
 */
public class MyHashmap<K, V> {


    private static int DEFAULT_CAPACITY = 10;

    private Entity<K, V>[] table;//数组

    private int size = 0;

    public MyHashmap() {
        clear();
    }

    private void clear() {
        table = new Entity[DEFAULT_CAPACITY];
    }

//    public V put(K key, V value) {
//        if (key == null) {
//            return null;
//        }
//        int hash = key.hashCode();
//        int index = indexFor(hash, table.length);
//
//        Entity<K, V> entity = table[index];
//        // 如果key已经存在，修改value
//        if (entity != null) {
//            if (entity.getKey().equals(key)) {
//                V oldValue = entity.getValue();
//                entity.setValue(value);
//                return oldValue;
//            }
//            entity = entity.next;
//        }else {
//            table[index] = new Entity<>(key, value, entity);
//            size++;
//            return null;
//        }
//    }


    public V put(K key, V value) {
        if (key == null)
            return null;
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        // 如果key已经存在，修改value
        for (Entity<K, V> e = table[index]; e != null; e = e.next) {
            if (e.getKey().equals(key)) {
                V oldValue = e.getValue();
                e.setValue(value);
                return oldValue;
            }
            e = e.next;
        }
        Entity<K, V> e = table[index];
        // 如果key不存在，则新建一个Entry
        table[index] = new Entity<K, V>(key, value, e);
        size++;
        return null;
    }


    public V get(K key) {
        if (key == null) {
            return null;
        }
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        for (Entity<K, V> head = table[index]; head != null; head = head.next) {
            // 先比较hashCode为了加法比较效率
            if (head.key.hashCode() == hash && head.key.equals(key)) {
                return head.getValue();
            }
        }
        return null;
    }


    // 根据hashcode求数组的位置
    private static int indexFor(int hash, int length) {
        return hash % (length - 1);
    }


    public int size() {
        return size;
    }


    //todo


    private class Entity<k, v> {
        private k key;

        private v value;

        private Entity<k, v> next;

        public Entity() {

        }

        public Entity(k key, v value) {
            this.key = key;
            this.value = value;
        }

        public Entity(k key, v value, Entity<k, v> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public k getKey() {
            return key;
        }

        public void setKey(k key) {
            this.key = key;
        }

        public v getValue() {
            return value;
        }

        public void setValue(v value) {
            this.value = value;
        }

        public Entity<k, v> getNext() {
            return next;
        }

        public void setNext(Entity<k, v> next) {
            this.next = next;
        }
    }

}
