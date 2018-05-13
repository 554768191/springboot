package org.chinaxin.api.splider.service;

import org.chinaxin.api.splider.model.Blog;

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
