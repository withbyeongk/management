package com.iron.management.site.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iron.management.site.model.dao.SiteDao;
import com.iron.management.site.model.vo.Site;

@Service
public class SiteServiceImpl implements SiteService {

	@Autowired
	private SiteDao siteDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

    @Override
    public int insertSite(Site site) {
        return siteDao.insertSite(sqlSession, site);
    }

    @Override
    public Site selectSite(String siteId) {
        return siteDao.selectSite(sqlSession, siteId);
    }

    @Override
    public int updateSite(Site site) {
        return siteDao.updateSite(sqlSession, site);
    }

    @Override
    public int deleteSite(Site site) {
        return siteDao.deleteSite(sqlSession, site);
    }

    @Override
    public ArrayList<Site> selectSiteList() {
        return siteDao.selectSiteList(sqlSession);
    }
	
}
