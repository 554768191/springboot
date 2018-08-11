package org.chinaxin.api.splider.service.impl;

import org.chinaxin.api.splider.dao.NewsDao;
import org.chinaxin.api.splider.model.News;
import org.chinaxin.api.splider.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    public NewsDao newsDao;
    @Override
    public void saveNews(News news) {
        newsDao.saveNews(news);
    }

    @Override
    public List<News> queryAllNews() {
        return newsDao.queryAllNews();
    }

    @Override
    public void deleteAllNews() {
        newsDao.deleteAllNews();
    }
}
