package com.iron.management.admin.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.admin.model.vo.Admin;


@Service
public interface AdminService {
	
	int insertAdmin(Admin adm);

    Admin selectAdmin(String adminId);

    ArrayList<Admin> selectAdminList();
	
}
