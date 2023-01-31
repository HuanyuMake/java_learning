package com.pdl.config;

import com.pdl.interceptor.HelloInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date: 2023/1/30 16:31
 *
 * @author 潘栋磊
 * @version 0.0.1
 * 代替SpringMVC的配置文件
 * 配置扫描控制层组件 普通控制器 异常处理控制器 拦截器
 * 还可以配置视图解析器
 * 配置默认的Servlet处理静态资源
 * 配置注册SpringMVC的注解驱动
 * 还可以配置视图控制器
 * 配置文件上传解析器
 *
 * 只需要重写WebMvcConfigurer接口的方法即可实现配置
 */
@Configuration // 将该类标识为配置类
@ComponentScan("com.pdl.controller") // 扫描组件
@EnableWebMvc // 开启SpringMVC的注解驱动
public class SpringMVCConfigurator implements WebMvcConfigurer {
    /**
     * 使用默认的Servlet处理静态资源
     * */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置Bean
     * 配置文件上传解析器
     * */
    @Bean  // 将标识的方法的返回值作为Bean管理
    public StandardServletMultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/abc"); // 任意层目录

    }
}
