package com.iron.management.menu.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iron.management.menu.model.dao.MenuDao;
import com.iron.management.menu.model.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;
    
    @Autowired
    private SqlSessionTemplate sqlSession;
    
    
    @Override
    public Menu selectMenu(String menuNm) {
        return menuDao.selectMenu(sqlSession, menuNm);
    }

    @Override
    public Menu selectMenu(int menuId) {
        return menuDao.selectMenu(sqlSession, menuId);
    }
    
    @Override
    public int insertMenu(Menu menu) {
        return menuDao.insertMenu(sqlSession, menu);
    }

    @Override
    public ArrayList<Menu> selectMenuList() {
        return menuDao.selectMenuList(sqlSession);
    }

    @Override
    public int deleteMenu(int menuId) {
        return menuDao.deleteMenu(sqlSession, menuId);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(sqlSession, menu);
    }

    @Override
    public int grantAccess(Menu menu) {
        return menuDao.grantAccess(sqlSession, menu);
    }

    @Override
    public int revokeAccess(Menu menu) {
        return menuDao.revokeAccess(sqlSession, menu);
    }

    
}
