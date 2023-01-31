package com.pdl.controller.impl;


import com.pdl.controller.UserController;
import com.pdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Date: 2023/1/27 16:53
 *
 * @author 潘栋磊
 * @version 0.0.1
 */

@Controller
public class UserControllerImpl implements UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Override
    public String toString() {
        return "UserControllerImpl{" +
                "userService=" + userService +
                '}';
    }
    @Autowired
    public UserControllerImpl setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
