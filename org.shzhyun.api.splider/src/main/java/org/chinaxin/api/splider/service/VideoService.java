package org.chinaxin.api.splider.service;

import org.chinaxin.api.splider.model.Video;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
//@Mapper
//@Component
public interface VideoService {
    Long saveBlog(Video video);
    List<Video> queryAllBlog();
}
