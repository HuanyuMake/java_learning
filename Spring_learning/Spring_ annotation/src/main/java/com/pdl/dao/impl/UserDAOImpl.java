package com.pdl.dao.impl;

import com.pdl.Main;
import com.pdl.dao.UserDAO;
import com.pdl.service.UserService;
import org.springframework.stereotype.Repository;

/**
 * Date: 2023/1/27 16:42
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private int id = (int)(Math.random()*10+1);

    @Override
    public String toString() {
        return "UserDAOImpl{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public UserDAOImpl setId(int id) {
        this.id = id;
        return this;
    }

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
