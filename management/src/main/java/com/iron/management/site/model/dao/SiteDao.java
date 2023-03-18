package com.iron.management.site.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.iron.management.site.model.vo.Site;

@Repository
public class SiteDao {

    public int insertSite(SqlSessionTemplate sqlSession, Site site) {
        return sqlSession.insert("siteMapper.insertSite", site);
    }

    public Site selectSite(SqlSessionTemplate sqlSession, String siteId) {
        return sqlSession.selectOne("siteMapper.selectSite", siteId);
    }

    public int updateSite(SqlSessionTemplate sqlSession, Site site) {
        return  sqlSession.update("siteMapper.updateSite", site);
    }

    public int deleteSite(SqlSessionTemplate sqlSession, Site site) {
        return sqlSession.delete("siteMapper.deleteSite", site);
    }

    public ArrayList<Site> selectSiteList(SqlSessionTemplate sqlSession) {
        return (ArrayList)sqlSession.selectList("siteMapper.deleteSite");
    }

    public int grantAccess(SqlSessionTemplate sqlSession, Site site) {
        return sqlSession.insert("siteMapper.grantAccess", site);
    }

    public int revokeAccess(SqlSessionTemplate sqlSession, Site site) {
        return sqlSession.update("siteMapper.revokeAccess", site);
    }

}
