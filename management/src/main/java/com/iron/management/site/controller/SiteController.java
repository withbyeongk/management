package com.iron.management.site.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iron.management.admin.model.service.AdminService;
import com.iron.management.admin.model.vo.Admin;
import com.iron.management.site.model.service.SiteService;
import com.iron.management.site.model.vo.Site;

@Controller
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
    private AdminService adminService;
	
    @RequestMapping("insertForm.st")
    public String goToInsertForm() {
        return "site/insertForm";
    }
    
	// 계정 등록
	@PostMapping("insert.st")
	public String insertSite(Site site,
							HttpSession session,
							Model model) {
		
	    // 입력 확인
	    if(site.getSiteId()==null || "".equals(site.getSiteId())) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        if(site.getSiteNm()==null || "".equals(site.getSiteNm())) {
            model.addAttribute("errorMsg","사이트 이름 입력 필요");
            return "common/errorPage";
        }
	    
	    
	    // 입력한 ID로 조회하여 중복 확인
	    Site dbSite = siteService.selectSite(site.getSiteId());
	    if(dbSite != null) {
	        model.addAttribute("errorMsg","이미 존재하는 사이트 ID");
            return "common/errorPage";
	    }
	    
		int result = siteService.insertSite(site);
		
		if(result>0) {
			session.setAttribute("alertMsg", "사이트 등록 완료");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg","사이트 등록 실패");
			
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateForm.st")
	public String goToUpdateForm() {
	    return "site/updateForm";
	}
	
    // 계정 정보 수정
	@RequestMapping("update.st")
    public String updateSite(Site site,
                            HttpSession session,
                            Model model) {

        // 입력 확인
	    if(site.getSiteId()==null || "".equals(site.getSiteId())) {
	        model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
	    }
	    if(site.getSiteNm()==null || "".equals(site.getSiteNm())) {
            model.addAttribute("errorMsg","사이트명 입력 필요");
            return "common/errorPage";
        }
	    
	    // 입력한 ID로 조회하여 중복 확인
        Site dbSite = siteService.selectSite(site.getSiteId());
        if(dbSite == null) {
            model.addAttribute("errorMsg","존재하는 사이트ID가 아님");
            return "common/errorPage";
        }
	    
	    int result = siteService.updateSite(site);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 수정 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 수정 실패");
            
            return "common/errorPage";
        }
	    
    }
	
	
    @RequestMapping("deleteForm.st")
    public String goToDeleteForm() {
        return "site/deleteForm";
    }
    
    @RequestMapping("delete.st")
    public String deleteSite(Site site
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(site.getSiteId()==null || "".equals(site.getSiteId())) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 중복 확인
        Site dbSite = siteService.selectSite(site.getSiteId());
        if(dbSite == null) {
            model.addAttribute("errorMsg","존재하는 사이트ID가 아님");
            return "common/errorPage";
        }
        
        int result = siteService.deleteSite(site);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 삭제 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 삭제 실패");
            
            return "common/errorPage";
        }
        
    }
    

    @RequestMapping("selectForm.st")
    public String goToSelectForm() {
        return "site/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectSite.st",produces="application/json; charset=UTF-8")
    public String selectSite(String siteId) {
        return new Gson().toJson(siteService.selectSite(siteId));
    }
    
    @ResponseBody
    @RequestMapping(value="selectSiteList.st",produces="application/json; charset=UTF-8")
    public String selectSiteList(HttpSession session, Model model) {
        return new Gson().toJson(siteService.selectSiteList());
    }
    

    @RequestMapping("accessForm.st")
    public String goToAccessForm() {
        return "site/accessForm";
    }
    
    @RequestMapping("grantAccess.st")
    public String grantAccess(Site site
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(site.getAdminId()==null || "".equals(site.getAdminId())) {
            model.addAttribute("errorMsg","A ID 입력 필요");
            return "common/errorPage";
        }
        if(site.getSiteId()==null || "".equals(site.getSiteId())) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 중복 확인
        Admin dbAdmin = adminService.selectAdmin(site.getAdminId());
        if(dbAdmin == null) {
            model.addAttribute("errorMsg","존재하는 ADMIN ID가 아님");
            return "common/errorPage";
        }
        
        Site dbSite = siteService.selectSite(site.getSiteId());
        if(dbSite == null) {
            model.addAttribute("errorMsg","존재하는 사이트ID가 아님");
            return "common/errorPage";
        }
        
        int result = siteService.grantAccess(site);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 권한 부여 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 권한 부여 실패");
            
            return "common/errorPage";
        }
        
    }
    
    @RequestMapping("revokeAccess.st")
    public String  revokeAccess(Site site
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(site.getAdminId()==null || "".equals(site.getAdminId())) {
            model.addAttribute("errorMsg","A ID 입력 필요");
            return "common/errorPage";
        }
        if(site.getSiteId()==null || "".equals(site.getSiteId())) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 중복 확인
        Admin dbAdmin = adminService.selectAdmin(site.getAdminId());
        if(dbAdmin == null) {
            model.addAttribute("errorMsg","존재하는 ADMIN ID가 아님");
            return "common/errorPage";
        }
        
        Site dbSite = siteService.selectSite(site.getSiteId());
        if(dbSite == null) {
            model.addAttribute("errorMsg","존재하는 사이트ID가 아님");
            return "common/errorPage";
        }
        
        int result = siteService.revokeAccess(site);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 권한 제거 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 권한 제거 실패");
            
            return "common/errorPage";
        }
        
    }
    
}
