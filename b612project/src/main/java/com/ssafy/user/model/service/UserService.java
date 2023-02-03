package com.ssafy.user.model.service;

import com.ssafy.user.model.dto.User;

public interface UserService {
	public User login(User memberDto) throws Exception;
	
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	
	public Object getRefreshToken(String userid) throws Exception;
	
	public void deleRefreshToken(String userid) throws Exception;
	
	public int insert(User user) throws Exception;
	
	public User select(String id) throws Exception;
	
	public int update(User user) throws Exception;
	
	public int delete(String id) throws Exception;
}
