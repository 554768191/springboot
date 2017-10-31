package org.myqcode.spring.dao;

import org.apache.ibatis.annotations.Mapper;
import org.myqcode.spring.model.Blog;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface BlogDao {
    Long saveBlog(Blog blog);
    List<Blog> queryAllBlog();
}
