package com.ssafy.answer.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.answer.model.dto.Answer;
import com.ssafy.answer.model.dto.AnswerParameter;

public interface AnswerDao {
	
	public int writeArticle(Answer answer) throws SQLException;
	public List<Answer> listArticle(AnswerParameter answerParameter) throws SQLException;
	public int getTotalCount(AnswerParameter answerParameter) throws SQLException;
	public Answer getArticle(int articleno) throws SQLException;
	public void updateHit(int articleno) throws SQLException;
	public int modifyArticle(Answer answer) throws SQLException;
	public int deleteArticle(int articleno) throws SQLException;
	
}