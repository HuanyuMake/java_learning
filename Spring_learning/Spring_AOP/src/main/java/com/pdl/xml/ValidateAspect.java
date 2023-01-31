package com.pdl.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Date: 2023/1/28 12:41
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class ValidateAspect {
    @Before("execution(* com.pdl.xml.TargetCalculator.div(double ,double ))")
    public void validateArgv(JoinPoint joinPoint){
        if((double)joinPoint.getArgs()[1]==.0) {
            throw new ArithmeticException("Can`t divide by 0");
        }
    }
}
