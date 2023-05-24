package com.iron.management.user.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class User {
	private String userId;
	private String userPw;
	private String userNewPw;
	private String userChk;
	private String groupId;
	private String userNm;
	private Date updDtm;
	private Date regDtm;
}
