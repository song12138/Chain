package testBeanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by paul on 2017/11/27.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TestBean) {
            TestBean testBean = (TestBean) bean;
            testBean.setKey("1");
            testBean.setValue("1");
            return bean;
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
