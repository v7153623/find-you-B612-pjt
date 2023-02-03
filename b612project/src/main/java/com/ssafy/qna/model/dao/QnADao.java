package com.ssafy.qna.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.qna.model.dto.QnA;
import com.ssafy.qna.model.dto.QnAParameter;

public interface QnADao {
	
	public int writeArticle(QnA qna) throws SQLException;
	public List<QnA> listArticle(QnAParameter QnAParameter) throws SQLException;
	public int getTotalCount(QnAParameter QnAParameter) throws SQLException;
	public QnA getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(QnA qna) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	
}