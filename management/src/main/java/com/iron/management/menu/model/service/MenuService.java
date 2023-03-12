package com.iron.management.menu.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.admin.model.vo.Admin;
import com.iron.management.menu.model.vo.Menu;

@Service
public interface MenuService {

    Menu selectMenu(String menuNm);

    int insertMenu(String menuNm);

    ArrayList<Menu> selectMenuList();

}
