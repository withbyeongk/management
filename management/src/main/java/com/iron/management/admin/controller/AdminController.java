package com.iron.management.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.iron.management.admin.model.service.AdminService;
import com.iron.management.admin.model.vo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptpasswordEncoder;
	
	//회원가입 등록
	@PostMapping("insert.me")
	public String insertMember(Admin adm,
							HttpSession session,
							Model model) {
		
		System.out.println("원본 패스워드 : "+adm.getAdminPw());
		String encPw = bcryptpasswordEncoder.encode(adm.getAdminPw());
		System.out.println("암호화 패스워드 : "+encPw);
		
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
}
