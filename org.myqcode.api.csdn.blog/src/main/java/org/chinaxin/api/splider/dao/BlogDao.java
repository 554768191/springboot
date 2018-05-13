package org.chinaxin.api.splider.dao;

import org.apache.ibatis.annotations.Mapper;
import org.chinaxin.api.splider.model.Blog;
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
