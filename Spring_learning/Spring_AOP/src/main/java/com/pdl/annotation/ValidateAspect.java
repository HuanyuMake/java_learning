package com.pdl.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Date: 2023/1/28 12:41
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
@Aspect
//@Order(1) // 切面优先级, 越高就越先执行(相对于其它切面), value越小,优先级越高
public class ValidateAspect {
    @Before("execution(* com.pdl.annotation.TargetCalculator.div(double ,double ))")
    public void validateArgv(JoinPoint joinPoint){
        if((double)joinPoint.getArgs()[1]==.0) {
            throw new ArithmeticException("Can`t divide by 0");
        }
    }
}
