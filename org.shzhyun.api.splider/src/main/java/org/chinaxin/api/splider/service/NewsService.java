package org.chinaxin.api.splider.service;

import org.chinaxin.api.splider.model.News;

import java.util.List;

public interface NewsService {
    void saveNews(News news);
    List<News> queryAllNews();

    void deleteAllNews();
}
