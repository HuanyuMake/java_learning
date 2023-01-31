package com.pdl.config;

import jakarta.servlet.Filter;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Date: 2023/1/30 16:24
 *
 * @author 潘栋磊
 * @version 0.0.1
 * 替代 web.xml的功能的配置器
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 设置一个配置类来替代Spring的applicationContext.xml
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfigurator.class};
    }

    /**
     * 设置一个配置类来替代SpringMVC的applicationContext.xml
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfigurator.class};
    }

    /*
     * 设置 SpringMVC前端控制器 DispatcherServlet的url-pattern
     */
    @Override
    protected String @NotNull [] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 设置过滤器数组
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
