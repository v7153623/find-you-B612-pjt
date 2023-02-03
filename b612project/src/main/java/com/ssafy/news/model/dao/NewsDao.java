package com.ssafy.news.model.dao;

import java.util.List;

import com.ssafy.news.model.dto.News;

public interface NewsDao {
	public int deleteAll();
	public int saveone(News news);
	public List<News> getNews();
}
