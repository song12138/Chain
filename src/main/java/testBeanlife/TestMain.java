package testBeanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by paul on 2017/11/27.
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/application.xml");
        TestBean testBean = applicationContext.getBean(TestBean.class);
        System.out.println(testBean.toString());
    }
}
