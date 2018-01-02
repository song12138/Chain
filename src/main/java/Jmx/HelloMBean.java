package Jmx;

/** 接口名必须以MBean结尾
 * Created by paul on 2017/11/30.
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);
}
