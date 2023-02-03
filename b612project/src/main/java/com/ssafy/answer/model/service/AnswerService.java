package com.ssafy.answer.model.service;

import java.util.List;

import com.ssafy.answer.util.PageNavigation;
import com.ssafy.answer.model.dto.Answer;
import com.ssafy.answer.model.dto.AnswerParameter;

public interface AnswerService {
	public boolean writeArticle(Answer answer) throws Exception;
	public List<Answer> listArticle(AnswerParameter answerParameter) throws Exception;
	public PageNavigation makePageNavigation(AnswerParameter answerParameter) throws Exception;
	
	public Answer getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(Answer answer) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
}
