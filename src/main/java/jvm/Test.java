package jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2017/12/14.
 */
public class Test {
    public static void main(String[] args) {
        List<OOMObject> lists = new ArrayList<OOMObject>();

        while (true) {
            lists.add(new OOMObject());
        }
        //***********************************************
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
    }



}
