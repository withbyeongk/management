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
		
	    // 입력 확인
	    if(adm.getAdminId()==null || "".equals(adm.getAdminId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        if(adm.getAdminPw()==null || "".equals(adm.getAdminPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
        if(adm.getAdminChk()==null || "".equals(adm.getAdminChk())) {
            model.addAttribute("errorMsg","비밀번호 확인 다시 필요");
            return "common/errorPage";
        }
        if(adm.getAdminNm()==null || "".equals(adm.getAdminNm())) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
	    
	    
	    // 입력한 ID로 조회하여 중복 확인
	    Admin dbAdm = adminService.selectAdmin(adm.getAdminId());
	    if(dbAdm != null) {
	        model.addAttribute("errorMsg","이미 존재하는 ID");
            return "common/errorPage";
	    }
	    
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

        // 입력 확인
	    if(adm.getAdminId()==null || "".equals(adm.getAdminId())) {
	        model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
	    }
	    if(adm.getAdminPw()==null || "".equals(adm.getAdminPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
	    if(adm.getAdminNewPw()==null || "".equals(adm.getAdminNewPw())) {
            model.addAttribute("errorMsg","새 비밀번호 입력 필요");
            return "common/errorPage";
        }
	    if(adm.getAdminChk()==null || "".equals(adm.getAdminChk())) {
            model.addAttribute("errorMsg","새 비밀번호 확인 다시 입력");
            return "common/errorPage";
        }
	    
	    // 조회해서 비밀번호 같으면 수정
	    Admin dbAdm = adminService.selectAdmin(adm.getAdminId());
	    
        if( dbAdm != null && bcryptpasswordEncoder.matches(adm.getAdminPw(), dbAdm.getAdminPw()) ) {
            
            
            if(adm.getAdminNewPw().equals(adm.getAdminChk())) {
                
                // 새 비밀번호를 암호화하여 다시 담기
                String encNewPw = bcryptpasswordEncoder.encode(adm.getAdminNewPw());
                adm.setAdminNewPw(encNewPw);
                
                int result = adminService.updateAdmin(adm);
                
                if(result>0) {
                    session.setAttribute("alertMsg", "수정 완료");
                    return "redirect:/";
                }else {
                    model.addAttribute("errorMsg","수정 실패");
                    return "common/errorPage";
                }
            }
            else {
                model.addAttribute("errorMsg","새 비밀번호 재입력");
                return "common/errorPage";
            }
        }
        model.addAttribute("errorMsg","비밀번호 불일치");
        return "common/errorPage";
    }
	
	
    @RequestMapping("deleteForm.ad")
    public String goToDeleteForm() {
        return "admin/deleteForm";
    }
    
    @RequestMapping("delete.ad")
    public String deleteAdmin(Admin adm
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(adm.getAdminId()==null || "".equals(adm.getAdminId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        if(adm.getAdminPw()==null || "".equals(adm.getAdminPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
        
        // 조회해서 비밀번호 같으면 삭제
        Admin dbAdm = adminService.selectAdmin(adm.getAdminId());
        
        if( dbAdm != null && bcryptpasswordEncoder.matches(adm.getAdminPw(), dbAdm.getAdminPw()) ) {

            int result = adminService.deleteAdmin(adm.getAdminId());
            
            if(result>0) {
                session.setAttribute("alertMsg", "삭제 완료");
                return "redirect:/";
            }else {
                model.addAttribute("errorMsg","계정 삭제 실패");
                
                return "common/errorPage";
            }
        }
        
        model.addAttribute("errorMsg","비밀번호 불일치");
        return "common/errorPage";
        
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
        return new Gson().toJson(adminService.selectAdminList());
    }
    
    
}
