package com.pdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date: 2023/1/28 21:11
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Controller
@RequestMapping("/h2") // 表示这个类处理以这个url开头的请求, 具体是哪个方法执行,就看 方法上该注解与该类注解拼接后的字符串
public class HelloController {
    // 这里的 "/" 是服务器解析的绝对路径即为 http://localhost:2999/上下文路径/
    // 上下文路径就是该项目打成war包后部署到tomcat服务器webapps目录下的文件名
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String portal(){
        System.out.println("/api/index");
        return "okokokkokook";
    }

    @RequestMapping({"/api"})
    public void hello(){
        System.out.println("/api/api");
    }
    @RequestMapping({"/"})
    public void ok(){
        System.out.println("/api");
    }
}
