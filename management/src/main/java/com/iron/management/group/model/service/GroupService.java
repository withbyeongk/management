package com.iron.management.group.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.group.model.vo.Group;


@Service
public interface GroupService {
	
	int insertGroup(Group group);

	Group selectGroup(String groupId);

    ArrayList<Group> selectGroupList();

    int deleteGroup(String groupId);

    int updateGroup(Group group);
	
}
