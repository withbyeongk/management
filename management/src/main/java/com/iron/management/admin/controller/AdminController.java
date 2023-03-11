package com.iron.management.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iron.management.admin.model.service.AdminService;
import com.iron.management.admin.model.vo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptpasswordEncoder;
	
	
	@RequestMapping("home.go")
    public String goToHome() {
        return "redirect:/";
    }
	
    @RequestMapping("insertForm.ad")
    public String goToInsertForm() {
        return "admin/insertForm";
    }
    
	// 계정 등록
	@PostMapping("insert.ad")
	public String insertAdmin(Admin adm,
							HttpSession session,
							Model model) {
		
		String encPw = bcryptpasswordEncoder.encode(adm.getAdminPw());
		
		adm.setAdminPw(encPw);
		
		int result = adminService.insertAdmin(adm);
		
		if(result>0) {
			session.setAttribute("alertMsg", "회원가입이 완료되었습니다.");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg","회원가입 실패");
			
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateForm.ad")
	public String goToUpdateForm() {
	    return "admin/updateForm";
	}
	
    // 계정 정보 수정
	@RequestMapping("update.ad")
    public String updateAdmin(Admin adm,
                            HttpSession session,
                            Model model) {

        if( !checkPwd(adm) ) {
            model.addAttribute("errorMsg","비밀번호 불일치");
            return "common/errorPage";
        }
        
        // 새 비밀번호를 암호화하여 adminPw에 대입
        adm.setAdminPw(bcryptpasswordEncoder.encode(adm.getAdminNewPw()));
        
        int result = adminService.insertAdmin(adm);
        
        if(result>0) {
            session.setAttribute("alertMsg", "계정 정보 수정 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","계정 정보 수정 실패");
            
            return "common/errorPage";
        }
    }
	
	
    @RequestMapping("deleteForm.ad")
    public String goToDeleteForm() {
        return "admin/deleteForm";
    }
    
    @RequestMapping("delete.ad")
    public String deleteAdmin(Admin adm
                            , HttpSession session
                            , Model model) {
        
        Admin dbAdm = adminService.selectAdmin(adm.getAdminId());
        
        // 조회해서 비밀번호 같으면 삭제
        if( !bcryptpasswordEncoder.matches(adm.getAdminPw(), dbAdm.getAdminPw()) ) {
            model.addAttribute("errorMsg","비밀번호 불일치");
            return "common/errorPage";
        }
        
        int result = adminService.deleteAdmin(adm.getAdminId());
        
        if(result>0) {
            session.setAttribute("alertMsg", "삭제 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","계정 삭제 실패");
            
            return "common/errorPage";
        }
        
    }
    

    @RequestMapping("selectForm.ad")
    public String goToSelectForm() {
        return "admin/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectAdmin.ad",produces="application/json; charset=UTF-8")
    public String selectAdmin(String adminId) {
        return new Gson().toJson(adminService.selectAdmin(adminId));
    }
    
    @ResponseBody
    @RequestMapping(value="selectAdminList.ad",produces="application/json; charset=UTF-8")
    public String selectAdminList(HttpSession session, Model model) {
        ArrayList<Admin> list = adminService.selectAdminList();
        return new Gson().toJson(list);
    }
    
    
}
