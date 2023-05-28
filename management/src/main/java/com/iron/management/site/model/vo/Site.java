package com.iron.management.site.model.vo;

import lombok.Data;

@Data
public class Site {
    private String siteId;
    private String siteUrl;
    private String siteComment;
    
    //access관련
    private String userId;
}
