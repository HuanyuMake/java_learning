package com.pdl.annotation;

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
@Aspect
public class LoggerAspect {
    /**
     * 声明一个 可复用的 公共的 切入点表达式
    * */
    @Pointcut("execution(* com.pdl.annotation.TargetCalculator.*(..))")
    public void pointCut(){}
    /**
     * @param joinPoint 切入点对象,可以获取目标对象该连接点的上下文信息<br/>
     * 前置通知 <br/>
     * 使用 @Before() 注解标识 execution() 为切入点表达式
     * 在目标方法执行前执行
     * (注意!!!注意!!!)--->>> 切入点表达式代表的方法必须完全一致
     * 即: 访问权限 返回值类型 全类名 方法名 参数列表的个数顺序类型一一对应
     * 若该切面无效, 除了要检查
     *  xml中是否使用 <aop:aspectj-autoproxy /> 标签开启AOP注解功能
     *  xml中是否将目标对象与切面对象都加载入IOC容器
     *  切面对象是否使用 @Aspect 注解标明其为切面对象
     *  所使用的通知方法是否标上 切入点注解 (比如前置通知注解 @Before)
     *  切入点注解的 Value 是否与 目标对象的 方法完全相同, (注意!!!注意!!!)点处要注意
     *  <br/>
     *  切入点注解
     *  在类名的地方也可以写成 * 表示在这个包路径下的所有类
     *  包的地方也可以写成 * 表示的含义同上
     *  <br/>
     *  我称 形如public double com.pdl.annotation.TargetCalculator.add(double ,double)
     *      为方法的签名信息
     * */
//    @Before("execution(public double com.pdl.annotation.TargetCalculator.add(double ,double))")
    @Before("execution(* com.pdl.annotation.TargetCalculator.*(..))") // 无论是什么返回值访问权限 无论这个方法名是什么 无论这个方法的参数列表是什么
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

//    复用切入点表达式
    @After("pointCut()")
    public void finallyAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("后置通知 在方法 "+methodName+" 的finally字句中执行");
    }
    @AfterReturning(value = "pointCut()",returning="res")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object res){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("返回通知 在方法 "+methodName+" 执行完毕并获取返回值时执行, 结果是: "+res);
    }

    @AfterThrowing(value="pointCut()",throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();

        System.out.println("异常通知 在方法 "+methodName+" 执行时发生异常时的catch字句中执行, 异常: "+e);
    }

    @Around("pointCut()")
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
