package org.chinaxin.api.splider.dao;

import org.chinaxin.api.splider.model.News;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NewsDao {
    void saveNews(News news);

    List<News> queryAllNews();

    void deleteAllNews();
}
