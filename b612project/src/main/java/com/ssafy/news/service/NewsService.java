
package com.ssafy.news.service;


import java.util.List;

import com.ssafy.news.model.dto.News;

public interface NewsService {
	public int deleteAll();
	public int saveone(News news);
	public List<News> getNews();
}
