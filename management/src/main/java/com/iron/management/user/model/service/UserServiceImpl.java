package com.iron.management.user.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iron.management.user.model.dao.UserDao;
import com.iron.management.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(sqlSession, user);
	}

    @Override
    public User selectUser(String userId) {
        return userDao.selectUser(sqlSession, userId);
    }

    @Override
    public ArrayList<User> selectUserList() {
        return userDao.selectUserList(sqlSession);
    }

    @Override
    public int deleteUser(String userId) {
        return userDao.deleteUser(sqlSession, userId);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(sqlSession, user);
    }
}
