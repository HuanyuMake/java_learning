package com.proxy_;

/**
 * Date: 2023/1/27 21:51
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Tests {
    public static void main(String[] args) {
//        staticProxy();
        dynamicProxy();
    }

    public static void staticProxy() {
        StaticCalculatorProxy staticCalculatorProxy = new StaticCalculatorProxy(new TargetCalculator());
        staticCalculatorProxy.add(1, 5);
    }

    /**
     * 动态代理
     * 1. jdk代理 生成的类位于 com.sun.proxy包下, 与目标类实现相同接口 类名为 com.sun.$proxyXXXX
     * 2. cglib代理 生成的类位于目标类同包下, 通过继承实现
     */
    public static void dynamicProxy() {
        LoggerProxyFactory loggerProxyFactory = new LoggerProxyFactory();

        Calculator proxy = (Calculator) loggerProxyFactory.getProxy(new TargetCalculator());

        proxy.add(18, 6);

        proxy.mul(8, 9);

        proxy.div(8, 0);

    }
}
