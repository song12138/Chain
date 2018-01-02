package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by paul on 2017/11/28.
 */
public class TestCollection {
    public static void main(String[] args) {
//        MyArraylist myArraylist = new MyArraylist();
//        myArraylist.add(1);
//        myArraylist.add(2);
//        myArraylist.add(3);
//        myArraylist.add(4);
//        myArraylist.add(5);
//        Iterator iterator = myArraylist.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.add(1);
//        myLinkedList.add(2);
//        myLinkedList.add(3);
//        myLinkedList.add(4);
//        myLinkedList.add(5);
//
//
//        Iterator iterator2 = myLinkedList.iterator();
//        while (iterator2.hasNext()) {
//            System.out.println(iterator2.next());
//        }

//        MyHashmap<String, String> myHashmap = new MyHashmap<>();
//
//        myHashmap.put("1", "1");
//        myHashmap.put("1", "2");
//        myHashmap.put("1", "3");
//        myHashmap.put("2", "1");


        MyTree myTree = new MyTree();

        myTree.insert((long)38);
        myTree.insert((long)8);
        myTree.insert((long)95);
        myTree.insert((long)66);
        myTree.insert((long)35);

        myTree.traverse(2);

    }






}
