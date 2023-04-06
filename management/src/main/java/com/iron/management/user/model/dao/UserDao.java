package com.iron.management.user.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.user.model.vo.User;

@Repository
public class UserDao {

	public int insertUser(SqlSessionTemplate sqlSession, User user) {
		return sqlSession.insert("userMapper.insertUser",user);
	}

    public User selectUser(SqlSessionTemplate sqlSession, String userId) {
        return sqlSession.selectOne("userMapper.selectUser",userId);
    }

    public ArrayList<User> selectUserList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("userMapper.selectUserList");
    }

    public int deleteUser(SqlSessionTemplate sqlSession, String userId) {
        return sqlSession.delete("userMapper.deleteUser", userId);
    }

    public int updateUser(SqlSessionTemplate sqlSession, User user) {
        return sqlSession.update("userMapper.updateUser",user);
    }

}
