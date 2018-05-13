package org.chinaxin.api.splider.dao;

import org.apache.ibatis.annotations.Mapper;
import org.chinaxin.api.splider.model.Video;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface VideoDao {
    Long saveBlog(Video video);
    List<Video> queryAllBlog();
}
