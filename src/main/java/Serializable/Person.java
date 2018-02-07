package Serializable;

import java.io.Serializable;

/**
 * Created by paul on 2018/2/7.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5216549558614491606L;

    private String name;

    private String sex;

    private String age;

    public Person(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
