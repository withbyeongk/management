package com.iron.management.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iron.management.admin.model.dao.AdminDao;
import com.iron.management.admin.model.vo.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertAdmin(Admin adm) {
		return adminDao.insertAdmin(sqlSession, adm);
	}

    @Override
    public Admin selectAdmin(String adminId) {
        return adminDao.selectAdmin(sqlSession, adminId);
    }

    @Override
    public ArrayList<Admin> selectAdminList() {
        return adminDao.selectAdminList(sqlSession);
    }

    @Override
    public int deleteAdmin(String adminId) {
        return adminDao.deleteAdmin(sqlSession);
    }
}
