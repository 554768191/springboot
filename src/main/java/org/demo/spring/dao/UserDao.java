package org.demo.spring.dao;

import org.demo.spring.model.User;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public interface UserDao {
    Long saveUser(User user);
    String getPasswordByUserName(String username);
}
