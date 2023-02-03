package com.ssafy.qna.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.qna.util.PageNavigation;
import com.ssafy.qna.model.dto.QnA;
import com.ssafy.qna.model.dto.QnAParameter;
import com.ssafy.qna.model.dao.QnADao;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean writeArticle(QnA qna) throws Exception {
		if(qna.getSubject() == null || qna.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnADao.class).writeArticle(qna) == 1;
	}

	@Override
	public List<QnA> listArticle(QnAParameter qnaParameter) throws Exception {
		int start = qnaParameter.getPg() == 0 ? 0 : (qnaParameter.getPg() - 1) * qnaParameter.getSpp();
		qnaParameter.setStart(start);
		return sqlSession.getMapper(QnADao.class).listArticle(qnaParameter);
	}

	@Override
	public PageNavigation makePageNavigation(QnAParameter qnaParameter) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(qnaParameter.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(QnADao.class).getTotalCount(qnaParameter);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / qnaParameter.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = qnaParameter.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < qnaParameter.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public QnA getArticle(int articleno) throws Exception {
		return sqlSession.getMapper(QnADao.class).getArticle(articleno);
	}
	
	@Override
	public void updateHit(int articleno) throws Exception {
		sqlSession.getMapper(QnADao.class).updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(QnA qna) throws Exception {
		return sqlSession.getMapper(QnADao.class).modifyArticle(qna) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return sqlSession.getMapper(QnADao.class).deleteArticle(articleno) == 1;
	}
}