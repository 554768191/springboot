package org.chinaxin.api.splider.service.impl;

import org.chinaxin.api.splider.dao.VideoDao;
import org.chinaxin.api.splider.model.Video;
import org.chinaxin.api.splider.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao blogDao;
    @Override
    public Long saveBlog(Video video) {
        return blogDao.saveBlog(video);
    }
    @Override
    public List<Video> queryAllBlog() {
        return blogDao.queryAllBlog();
    }

}
