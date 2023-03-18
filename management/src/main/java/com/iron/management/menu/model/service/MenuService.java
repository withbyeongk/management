package com.iron.management.menu.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.admin.model.vo.Admin;
import com.iron.management.menu.model.vo.Menu;

@Service
public interface MenuService {

    Menu selectMenu(String menuNm);
    
    Menu selectMenu(int menuId);

    int insertMenu(Menu menu);

    ArrayList<Menu> selectMenuList();

    int deleteMenu(int menuId);

    int updateMenu(Menu menu);

    // 메뉴 접근권한 부여
    int grantAccess(Menu menu);

    // 메뉴 접근권한 회수
    int revokeAccess(Menu menu);

}
