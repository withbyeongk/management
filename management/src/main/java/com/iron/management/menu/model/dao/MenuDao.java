package com.iron.management.menu.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.menu.model.vo.Menu;

@Repository
public class MenuDao {
    
    public Menu selectMenu(SqlSessionTemplate sqlSession, String menuNm) {
        return sqlSession.selectOne("menuMapper.selectMenu",menuNm);
    }

    public int insertMenu(SqlSessionTemplate sqlSession, String menuNm) {
        return sqlSession.insert("menuMapper.insertMenu",menuNm);
    }

    public ArrayList<Menu> selectMenuList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("menuMapper.selectMenuList");
    }

}
