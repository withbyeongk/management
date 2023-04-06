package com.iron.management.site.model.vo;

import lombok.Data;

@Data
public class Site {
    private String siteId;
    private String siteNm;
    
    //access관련
    private String userId;
}
