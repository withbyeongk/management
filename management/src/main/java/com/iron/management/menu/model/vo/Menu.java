package com.iron.management.menu.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Menu {
    private int menuId;
    private String menuNm;
    private String menuUrl;
    private int menuRefId;      // 업데이트 시 이동할 곳의 상위 메뉴 ID
    private int menuLevel;      // 업데이트 시 이동할 곳의 메뉴 레벨
    private int menuOrder;      // 업데이트 시 이동할 곳의 메뉴 순서
    private int beforeRefId;
    private int beforeLevel;
    private int beforeOrder;
    private Date menuMdfDate;
    private Date menuRegDate;
    
    // 접근 권한 관련
    private String userId;
    
}
