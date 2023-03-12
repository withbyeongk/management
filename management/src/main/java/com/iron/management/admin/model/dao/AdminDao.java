package com.iron.management.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.admin.model.vo.Admin;

@Repository
public class AdminDao {

	public int insertAdmin(SqlSessionTemplate sqlSession, Admin adm) {
		return sqlSession.insert("adminMapper.insertAdmin",adm);
	}

    public Admin selectAdmin(SqlSessionTemplate sqlSession, String adminId) {
        return sqlSession.selectOne("adminMapper.selectAdmin",adminId);
    }

    public ArrayList<Admin> selectAdminList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("adminMapper.selectAdminList");
    }

    public int deleteAdmin(SqlSessionTemplate sqlSession, String adminId) {
        return sqlSession.delete("adminMapper.deleteAdmin", adminId);
    }

    public int updateAdmin(SqlSessionTemplate sqlSession, Admin adm) {
        return sqlSession.update("adminMapper.updateAdmin",adm);
    }

}
