package com.pdl.xml;

import com.pdl.Calculator;
import com.pdl.MyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

/**
 * Date: ${DATE} ${TIME}
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Main {
    public static void main(String[] args) {
        MyUtils.setConfigPath("appCtx_AOP-XML.xml");
        ApplicationContext ioc = MyUtils.getIOC();
//        这里实质上是获取了AOP代理对象,(IOC中无法获取目标对象) 因为代理对象与目标对象实现的
//        接口一致, 所以可以通过 向上转型 来使用代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(88,99);
        calculator.sub(88,99);
    }

   @Test
    public void useAOPAnnotation(){
       MyUtils.setConfigPath("appCtx_AOP-XML.xml");
        ApplicationContext ioc = MyUtils.getIOC();
//        这里实质上是获取了AOP代理对象,(IOC中无法获取目标对象) 因为代理对象与目标对象实现的
//        接口一致, 所以可以通过 向上转型 来使用代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(88,99);
        calculator.sub(88,99);
//        calculator.div(88,0);
    }
}