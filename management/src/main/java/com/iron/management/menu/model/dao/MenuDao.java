package com.iron.management.menu.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.menu.model.vo.Menu;

@Repository
public class MenuDao {
    
    public Menu selectMenu(SqlSessionTemplate sqlSession, String menuNm) {
        return sqlSession.selectOne("menuMapper.selectMenuByName",menuNm);
    }
    
    public Menu selectMenu(SqlSessionTemplate sqlSession, int menuId) {
        return sqlSession.selectOne("menuMapper.selectMenuById",menuId);
    }

    public int insertMenu(SqlSessionTemplate sqlSession, Menu menu) {
        return sqlSession.insert("menuMapper.insertMenu",menu);
    }

    public ArrayList<Menu> selectMenuList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("menuMapper.selectMenuList");
    }

    public int deleteMenu(SqlSessionTemplate sqlSession, int menuId) {
        return sqlSession.delete("menuMapper.deleteMenu", menuId);
    }

    public int updateMenu(SqlSessionTemplate sqlSession, Menu menu) {
        int result = 1;
        result *= sqlSession.update("menuMapper.updateBeforeSort", menu);
        result *= sqlSession.update("menuMapper.updateAfterSort", menu);
        result *= sqlSession.update("menuMapper.updateMoveMenu", menu);
        result *= sqlSession.update("menuMapper.updateMenuInfo", menu);
        return result;
    }

}
