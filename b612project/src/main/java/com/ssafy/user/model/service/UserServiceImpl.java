package com.ssafy.user.model.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	private UserDao dao;
	
	
	@Override
	public User login(User memberDto) throws Exception {
		if (memberDto.getId() == null || memberDto.getPwd() == null)
			return null;
		return sqlSession.getMapper(UserDao.class).login(memberDto);
	}
	
	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		sqlSession.getMapper(UserDao.class).saveRefreshToken(map);
	}
	
	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return sqlSession.getMapper(UserDao.class).getRefreshToken(userid);
	}
	
	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		sqlSession.getMapper(UserDao.class).deleteRefreshToken(map);
	}

	
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public int insert(User user) {
		return dao.insert(user);
	}

	@Override
	public User select(String id) {
		return dao.select(id);
	}

	@Override
	public int update(User user) {
		return dao.update(user);
	}

	@Override
	public int delete(String id) {
		return dao.delete(id);
	}

}
