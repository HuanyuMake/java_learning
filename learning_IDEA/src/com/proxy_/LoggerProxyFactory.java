package com.proxy_;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Date: 2023/1/27 21:52
 *
 * @author 潘栋磊
 * @version 0.0.1
 * 此处使用jdk代理
 */
public final class LoggerProxyFactory {
    private Object target;

    public LoggerProxyFactory(Object target) {
        this.target = target;
    }

    public LoggerProxyFactory() {
    }

    public @NotNull Object getProxy(Object target) {
        ClassLoader ApplicationClassLoader = this.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy 要被执行代理的对象
             * @param method 需要被执行的方法对象, 通过 method.invoke(执行该方法的对象,传参列表) 执行方法
             *               与 javaScript的 Function.property.call() 方法功能本质上是一样的
             * @param args 调用该方法时的参数列表
             * */
            @Override
            public Object invoke(Object proxy, @NotNull Method method, Object[] args) throws Throwable {
                Object result = null;
                String methodName = method.getName();
                try {
                    System.out.println("[日志]: 执行了方法 " + methodName + " 入参: " + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[日志]: 执行了方法 " + methodName + " 结果: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[日志]: 执行了方法 " + methodName + " 抛出异常: ");
                } finally {
                    System.out.println("必要工作");
                }
                return result;
            }
        };

        return Proxy.newProxyInstance(ApplicationClassLoader, interfaces, invocationHandler);
    }

    public Object getProxy() {
        return getProxy(this.target);
    }
}
