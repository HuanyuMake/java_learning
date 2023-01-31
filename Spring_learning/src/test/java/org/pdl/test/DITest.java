package org.pdl.test;

import org.junit.Test;
import org.pdl.pojo.Team;
import org.pdl.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class DITest {
    private final AtomicReference<ApplicationContext> ioc = new AtomicReference<>();
    public ApplicationContext getIOC(){
//        System.out.println(this.ioc.get());
        if(this.ioc.get() == null) {
            ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
            this.ioc.set(ioc);
        }
        return this.ioc.get();
    }
    @Test
    public void say(){
//        final ApplicationContext ioc = getIOC();
        org.pdl.pojo.HelloWorld helloWorld = getIOC().getBean("helloWorld", org.pdl.pojo.HelloWorld.class);

        helloWorld.sayHello();

    }
    @Test
    public void literalConstantDI(){
        User user = getIOC().getBean("user",User.class);
        System.out.println(user);
    }

    @Test
    public void referenceDI(){
        User user = getIOC().getBean("userRefDI", User.class);
        System.out.println(user);
    }
    @Test
    public void listAndMapDI(){
        Team team = getIOC().getBean("team", Team.class);
        System.out.println(team);
    }

}
