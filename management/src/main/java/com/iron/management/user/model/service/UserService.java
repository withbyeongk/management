package com.iron.management.user.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.user.model.vo.User;


@Service
public interface UserService {
	
	int insertUser(User user);

	User selectUser(String userId);

    ArrayList<User> selectUserList();

    int deleteUser(String userId);

    int updateUser(User user);
	
}
