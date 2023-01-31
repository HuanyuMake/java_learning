package org.pdl.service.impl;

import org.pdl.dao.UserDAO;
import org.pdl.service.UserService;

/**
 * @author 潘栋磊
 * @version 0.0.1
 * Date: 2023/1/27
 * 处理业务逻辑, 要调用数据层 DAO
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public void saveUser() {
        userDAO.saveUser();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public UserServiceImpl setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
        return this;
    }
}
