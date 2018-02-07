package Serializable;

import java.io.*;

/**
 * Created by paul on 2018/2/7.
 */
public class SerialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("sxf", "man", "24");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:/person.dat"));
        outputStream.writeObject(person);
        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:/person.dat"));
        Object obj = inputStream.readObject();
        Person p = (Person) obj;

        System.out.println(Person.getSerialVersionUID());
        System.out.println(p.getName()+p.getSex()+p.getAge());
    }
}
