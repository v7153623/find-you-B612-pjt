package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.util.PageNavigation;
import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.BoardParameterDto;

public interface BoardService {
	public boolean writeArticle(BoardDto qna) throws Exception;
	public List<BoardDto> listArticle(BoardParameterDto boardParameter) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto boardParameter) throws Exception;
	
	public BoardDto getArticle(int articleno) throws Exception;
	public void updateHit(int articleno) throws Exception;
	public boolean modifyArticle(BoardDto boardDto) throws Exception;
	public boolean deleteArticle(int articleno) throws Exception;
}
