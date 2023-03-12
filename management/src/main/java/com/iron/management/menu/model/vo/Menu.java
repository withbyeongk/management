package com.iron.management.menu.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Menu {
    private int menuId;
    private String menuNm;
    private String menuUrl;
    private int menuLevel;
    private int menuRefId;
    private int menuOrder;
    private Date menuMdfDate;
    private Date menuRegDate;
    
}
