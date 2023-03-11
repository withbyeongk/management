package com.iron.management.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.admin.model.vo.Admin;

@Repository
public class AdminDao {

	public int insertAdmin(SqlSessionTemplate sqlSession, Admin adm) {
		return sqlSession.insert("adminMapper.insertAdmin",adm);
	}

}
