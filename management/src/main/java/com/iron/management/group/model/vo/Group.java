package com.iron.management.group.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class Group {
	private String groupId;
	private String groupNm;
	private Date updDtm;
	private Date regDtm;
}
