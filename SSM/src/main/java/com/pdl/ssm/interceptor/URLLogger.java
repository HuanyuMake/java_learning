package com.pdl.ssm.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

/**
 * Date: 2023/1/30 21:48
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class URLLogger implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss"));

        System.out.println("Host: "+request.getRemoteHost()+"  URI: "+request.getRequestURI()
                +"\n  Method: "+request.getMethod()
                +"\n"+format);
        return true;
    }
}
