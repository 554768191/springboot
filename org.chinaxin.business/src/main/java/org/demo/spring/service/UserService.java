package org.demo.spring.service;

import org.demo.spring.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
//@Mapper
//@Component
public interface UserService {
    Long saveUser(User user);
    User getUser(String username);
    String getPasswordByUserName(String username);

    List<User> queryUsers();
}
