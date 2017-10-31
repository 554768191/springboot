package org.myqcode.spring.service.impl;

import org.myqcode.spring.dao.BlogDao;
import org.myqcode.spring.model.Blog;
import org.myqcode.spring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;
    @Override
    public Long saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }
    @Override
    public List<Blog> queryAllBlog() {
        return blogDao.queryAllBlog();
    }

}
