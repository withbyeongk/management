package com.iron.management.site.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.iron.management.site.model.vo.Site;


@Service
public interface SiteService {

    int insertSite(Site site);

    Site selectSite(String siteId);

    int updateSite(Site site);

    int deleteSite(Site site);
	
	ArrayList<Site> selectSiteList();

	// 접근 권한 부여
    int grantAccess(Site site);

    // 접근 권한 회수
    int revokeAccess(Site site);

}
