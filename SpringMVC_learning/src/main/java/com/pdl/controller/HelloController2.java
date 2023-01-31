package com.pdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2023/1/29 0:16
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Controller
@RequestMapping("/api")
public class HelloController2 {
    @RequestMapping("/1")
    public void t1(){
        System.out.println("HelloController2 /1");
    }
}
