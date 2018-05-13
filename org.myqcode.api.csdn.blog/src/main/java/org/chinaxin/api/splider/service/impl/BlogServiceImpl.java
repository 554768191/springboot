package org.chinaxin.api.splider.service.impl;

import org.chinaxin.api.splider.dao.BlogDao;
import org.chinaxin.api.splider.service.BlogService;
import org.chinaxin.api.splider.model.Blog;
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
