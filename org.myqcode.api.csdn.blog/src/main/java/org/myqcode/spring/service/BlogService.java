package org.myqcode.spring.service;

import org.myqcode.spring.model.Blog;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
//@Mapper
//@Component
public interface BlogService {
    Long saveBlog(Blog blog);
    List<Blog> queryAllBlog();
}
