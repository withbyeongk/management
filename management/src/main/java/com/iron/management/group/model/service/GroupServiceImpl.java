package com.iron.management.group.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iron.management.group.model.dao.GroupDao;
import com.iron.management.group.model.vo.Group;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertGroup(Group group) {
		return groupDao.insertGroup(sqlSession, group);
	}

    @Override
    public Group selectGroup(String groupId) {
        return groupDao.selectGroup(sqlSession, groupId);
    }

    @Override
    public ArrayList<Group> selectGroupList() {
        return groupDao.selectGroupList(sqlSession);
    }

    @Override
    public int deleteGroup(String groupId) {
        return groupDao.deleteGroup(sqlSession, groupId);
    }

    @Override
    public int updateGroup(Group group) {
        return groupDao.updateGroup(sqlSession, group);
    }
}
