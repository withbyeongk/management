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
    public int insertMenu(String menuNm) {
        return menuDao.insertMenu(sqlSession, menuNm);
    }

    @Override
    public ArrayList<Menu> selectMenuList() {
        return menuDao.selectMenuList(sqlSession);
    }
    
}
