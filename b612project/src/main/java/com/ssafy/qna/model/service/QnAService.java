package com.ssafy.qna.model.service;

import java.util.List;

import com.ssafy.qna.util.PageNavigation;
import com.ssafy.qna.model.dto.QnA;
import com.ssafy.qna.model.dto.QnAParameter;

public interface QnAService {
	public boolean writeArticle(QnA qna) throws Exception;
	public List<QnA> listArticle(QnAParameter qnaParameter) throws Exception;
	public PageNavigation makePageNavigation(QnAParameter qnaParameter) throws Exception;
	
	public QnA getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(QnA qna) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
}
