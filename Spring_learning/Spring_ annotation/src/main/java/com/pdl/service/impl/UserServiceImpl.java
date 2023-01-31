package com.pdl.service.impl;

import com.pdl.dao.UserDAO;
import com.pdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 潘栋磊
 * @version 0.0.1
 * Date: 2023/1/27
 * 处理业务逻辑, 要调用数据层 DAO
 */
@Service

public class UserServiceImpl implements UserService {
    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDAO=" + userDAO +
                '}';
    }


//    @Autowired "不建议直接在属性上写该注解" Spring的提示
    private UserDAO userDAO;

    @Override
    public void saveUser() {
        userDAO.saveUser();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    @Autowired
    public UserServiceImpl setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
        return this;
    }
}
