package com.pdl.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Date: 2023/1/27 23:19
 *
 * @author 潘栋磊
 * @version 0.0.1
 *
 * 在切面中,需要使用切入点注解将方法标记为通知方法
 * @Before 前置通知 在方法执行前执行
 * @After 后置通知 在方法的finally子句中执行
 *
 */
@Component
public class LoggerAspect {
    public void beforeAdviceMethod(JoinPoint joinPoint){
//        获取连接点的签名信息
        Signature signature = joinPoint.getSignature();
//        方法名
        String methodName = signature.getName();
//        声明类型 如 class ClassName   interface InterfaceName
        Class declaringType = signature.getDeclaringType();
//
        int modifiers = signature.getModifiers();
//        返回完整的签名信息 (好像没有 访问修饰符)
        String s = signature.toString();
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知 方法名: "+methodName+", "+
                declaringType+ ", "+modifiers+", "+ s+" , 实参列表: "+ Arrays.toString(args));
    }

    public void finallyAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("后置通知 在方法 "+methodName+" 的finally字句中执行");
    }
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object res){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("返回通知 在方法 "+methodName+" 执行完毕并获取返回值时执行, 结果是: "+res);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("异常通知 在方法 "+methodName+" 执行时发生异常时的catch字句中执行, 异常: "+e);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知> 前置");
            result = joinPoint.proceed();
            System.out.println("环绕通知> 返回");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知> 异常");
        } finally {
            System.out.println("环绕通知> 后置");
        }
        return result;
    }
}
