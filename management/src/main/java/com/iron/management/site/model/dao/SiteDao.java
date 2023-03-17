package com.iron.management.site.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.admin.model.vo.Admin;
import com.iron.management.site.model.vo.Site;

@Repository
public class SiteDao {

    public int insertSite(SqlSessionTemplate sqlSession, Site site) {
        return 0;
    }

    public Site selectSite(SqlSessionTemplate sqlSession, String siteId) {
        return null;
    }

    public int updateSite(SqlSessionTemplate sqlSession, Site site) {
        return 0;
    }

    public int deleteSite(SqlSessionTemplate sqlSession, Site site) {
        return 0;
    }

    public ArrayList<Site> selectSiteList(SqlSessionTemplate sqlSession) {
        return null;
    }

}
