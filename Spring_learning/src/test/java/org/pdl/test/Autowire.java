package org.pdl.test;

import org.junit.Test;
import org.pdl.controller.UserController;
import org.pdl.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Date: 2023/1/27 17:07
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Autowire {
    private final AtomicReference<ApplicationContext> ioc = new AtomicReference<>();
    public ApplicationContext getIOC(){
//        System.out.println(this.ioc.get());
        if(this.ioc.get() == null) {
            ApplicationContext ioc = new ClassPathXmlApplicationContext("appCtx-autowire.xml");
            this.ioc.set(ioc);
        }
        return this.ioc.get();
    }
    @Test
    public void testAutoWire(){
//        以下手动调用Controller 以后Web项目使用SpringMVC,其会帮我们调用
        UserController controller = getIOC().getBean("userController",UserController.class);
        controller.saveUser();
    }

}
