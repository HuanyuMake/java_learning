package com.pdl.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date: 2023/1/30 15:11
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class FirstInterceptor implements HandlerInterceptor {
    // 控制器方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pass = request.getParameter("pass");
        // 写了以下会乱码, 如果想返回json,可以在这里抛出一个自定义异常, 在异常控制器里可以返回json
        // response.setCharacterEncoding("UTF-8");
        // response.getWriter().write("pre interceptor");

        // 这里抛出异常, 也可以被异常控制器类处理
        // throw new ArithmeticException("创造一个算数逻辑异常");
        boolean res = "true".equals(pass);

        System.out.println("pre pass! res"+ res);

        return true;
    }

    // 控制器方法执行后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("post pass! ****");
    }
    // 控制器方法执行完毕,视图加载完成后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion pass! ****");
    }
}
