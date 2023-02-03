package com.ssafy.news.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.news.model.dao.NewsDao;
import com.ssafy.news.model.dto.News;

@Service
public class NewsServiceImpl implements NewsService {
		private NewsDao newsDao;
		
		public NewsServiceImpl(NewsDao newsDao) {
			this.newsDao=newsDao;
		}
		
		@Override
		public int deleteAll() {
			return newsDao.deleteAll();
		}

		@Override
		public int saveone(News news) {
			return newsDao.saveone(news);
		}

		@Override
		public List<News> getNews() {
			return newsDao.getNews();
		}

}
