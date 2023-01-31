package com.pdl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Date: 2023/1/30 15:59
 *
 * @author 潘栋磊
 * @version 0.0.1
 * @ControllerAdvice 配置该类为异常控制器类
 */
@ControllerAdvice
public class ExceptionHandleController {
    /*@ResponseBody
    @ExceptionHandler
    public String handle404(){

        return "404";
    }*/

    /**
     * 可以返回json 和普通的控制器方法作用一样, 只是不需要url映射而是需要对应异常才可调用该方法
     * */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class) //这个可以是个数组
    public String handleArithmeticException(){
        return "ArithmeticException";
    }
}
