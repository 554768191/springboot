package org.demo.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.demo.spring.model.User;
import org.springframework.stereotype.Component;
/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface UserDao {
    Long saveUser(User user);
    User getUser(String username);
    String getPasswordByUserName(String username);
}
