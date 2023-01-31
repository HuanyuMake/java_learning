package org.pdl.dao.impl;

import org.pdl.dao.UserDAO;
import org.pdl.service.UserService;

/**
 * Date: 2023/1/27 16:42
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class UserDAOImpl implements UserDAO {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public UserDAOImpl setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    @Override
    public void saveUser() {
        System.out.println("调用数据库保存用户");
    }
}
