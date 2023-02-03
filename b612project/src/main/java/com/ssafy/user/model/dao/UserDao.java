package com.ssafy.user.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.user.model.dto.User;

public interface UserDao {
	
	public User login(User memberDto) throws SQLException;
	
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	
	public Object getRefreshToken(String userid) throws SQLException;
	
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	int insert(User user);
	
	User select(String id);
	
	int update(User user);
	
	int delete(String id);

}
