package org.pdl.test;

import org.junit.Test;
import org.pdl.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class FactoryBeanTest {
    private final AtomicReference<ApplicationContext> ioc = new AtomicReference<>();
    public ApplicationContext getIOC(){
//        System.out.println(this.ioc.get());
        if(this.ioc.get() == null) {
            ApplicationContext ioc = new ClassPathXmlApplicationContext("appCtx-2.xml");
            this.ioc.set(ioc);
        }
        return this.ioc.get();
    }
    @Test
    public void getUserByFactory(){
        System.out.println(getIOC().getBean("userFactory", User.class));
    }


}
