package org.pdl.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class myBeanPostProcessor implements BeanPostProcessor {
    /**
     * @param bean 就是ico管理的对象
     * @param beanName 就是bean的id
     * */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor > 初始化前, 所有Bean都会调用");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor > 初始化后, 所有Bean都会调用");
        return bean;
    }
}
