package com.iron.management.user.model.vo;

import java.sql.Date;

import lombok.Data;



@Data
public class User {
	private String userId;
	private String userPw;
	private String userNewPw;
	private String userChk;
	private String userNm;
	private Date updDtm;
	private Date regDtm;
}
