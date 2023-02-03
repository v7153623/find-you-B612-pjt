package com.ssafy.answer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.answer.util.PageNavigation;
import com.ssafy.answer.model.dao.AnswerDao;
import com.ssafy.answer.model.dto.Answer;
import com.ssafy.answer.model.dto.AnswerParameter;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean writeArticle(Answer answer) throws Exception {
		if(answer.getSubject() == null || answer.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(AnswerDao.class).writeArticle(answer) == 1;
	}

	@Override
	public List<Answer> listArticle(AnswerParameter answerParameter) throws Exception {
		int start = answerParameter.getPg() == 0 ? 0 : (answerParameter.getPg() - 1) * answerParameter.getSpp();
		answerParameter.setStart(start);
		return sqlSession.getMapper(AnswerDao.class).listArticle(answerParameter);
	}

	@Override
	public PageNavigation makePageNavigation(AnswerParameter answerParameter) throws Exception {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(answerParameter.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(AnswerDao.class).getTotalCount(answerParameter);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / answerParameter.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = answerParameter.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < answerParameter.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public Answer getArticle(int articleno) throws Exception {
		return sqlSession.getMapper(AnswerDao.class).getArticle(articleno);
	}
	
	@Override
	public void updateHit(int articleno) throws Exception {
		sqlSession.getMapper(AnswerDao.class).updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean modifyArticle(Answer answer) throws Exception {
		return sqlSession.getMapper(AnswerDao.class).modifyArticle(answer) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) throws Exception {
		return sqlSession.getMapper(AnswerDao.class).deleteArticle(articleno) == 1;
	}
}