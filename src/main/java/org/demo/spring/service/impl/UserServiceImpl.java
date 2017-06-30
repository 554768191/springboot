package org.demo.spring.service.impl;

import org.demo.spring.dao.UserDao;
import org.demo.spring.model.User;
import org.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public Long saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public String getPasswordByUserName(String username) {
        return userDao.getPasswordByUserName(username);
    }
}
