package com.iron.management.group.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.group.model.vo.Group;

@Repository
public class GroupDao {

	public int insertGroup(SqlSessionTemplate sqlSession, Group group) {
		return sqlSession.insert("groupMapper.insertGroup",group);
	}

    public Group selectGroup(SqlSessionTemplate sqlSession, String groupId) {
        return sqlSession.selectOne("groupMapper.selectGroup",groupId);
    }

    public ArrayList<Group> selectGroupList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("groupMapper.selectGroupList");
    }

    public int deleteGroup(SqlSessionTemplate sqlSession, String groupId) {
        return sqlSession.delete("groupMapper.deleteGroup", groupId);
    }

    public int updateGroup(SqlSessionTemplate sqlSession, Group group) {
        return sqlSession.update("groupMapper.updateGroup",group);
    }

}
