package org.pdl.controller.impl;


import org.pdl.controller.UserController;
import org.pdl.pojo.User;
import org.pdl.service.UserService;

/**
 * Date: 2023/1/27 16:53
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class UserControllerImpl implements UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public UserControllerImpl setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
