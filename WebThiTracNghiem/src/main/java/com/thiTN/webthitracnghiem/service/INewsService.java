package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.News;
import com.thiTN.webthitracnghiem.model.NewsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsService {
    Page<News> findAll(Pageable pageable);
    Page<News> findByTitle(String name, Pageable pageable);
    News save(NewsRequest news);
    News findById(int id);
    void remove(News news);
    List<News> findAll();
    List<News> getNewsInWeek();
    void save(News news);
}
