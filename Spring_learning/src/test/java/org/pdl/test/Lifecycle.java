package org.pdl.test;

import org.junit.Test;
import org.pdl.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Lifecycle {
    private final AtomicReference<ApplicationContext> ioc = new AtomicReference<>();
    public ApplicationContext getIOC(){
//        System.out.println(this.ioc.get());
        if(this.ioc.get() == null) {
            ApplicationContext ioc = new ClassPathXmlApplicationContext("appCtx-2.xml");
            this.ioc.set(ioc);
        }
        return this.ioc.get();
    }
    /**
     * Bean 的lifecycle
     * (当 scope为 singleton 时,在ioc容器创建时就会创建单例Bean)
     * (当 scope为 prototype 时,在获取Bean时才创建多例Bean,
     *  且在ioc关闭时,多例Bean的销毁流程也不会走)
     * 1. 实例化
     * 2. 依赖注入
     * 2.5 初始化前 调用用户实现了 BeanPostProcessor 接口的实现类的对应方法
     * 3. 初始化
     * 2.5 初始化后 调用用户实现了 BeanPostProcessor 接口的实现类的对应方法
     * 4. 销毁 IOC容器关闭时,所有的Bean被销毁
     * */
    @Test
    public void learnLifecycle(){
        ConfigurableApplicationContext ioc = (ConfigurableApplicationContext) getIOC();
        System.out.println(ioc.getBean("user", User.class));
        ioc.close();
//        System.out.println(ioc.getBean("user", User.class));
    }


}
