package com.iron.management.admin.model.vo;

import java.sql.Date;

import lombok.Data;



@Data
public class Admin {
	private String adminId;
	private String adminPw;
	private String adminChk;
	private String adminNm;
	private Date adminMdfDate;
	private Date adminRegDate;
}
