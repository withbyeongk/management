package com.iron.management.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iron.management.user.model.service.UserService;
import com.iron.management.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptpasswordEncoder;
	
	
	@RequestMapping("home.go")
    public String goToHome() {
        return "redirect:/";
    }
	
	@RequestMapping("managePage.go")
	public String goToManage() {
	    return "common/managePage";
	}
	
	@RequestMapping("login.go")
	public String login(User user,
                        HttpSession session,
                        Model model) {
	    
	    // 입력 확인
        if(user.getUserId()==null || "".equals(user.getUserId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        if(user.getUserPw()==null || "".equals(user.getUserPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 비밀번호 확인
        User dbUser = userService.selectUser(user.getUserId());
        if(dbUser == null) {
            model.addAttribute("errorMsg","존재하지 않는 ID");
            return "common/errorPage";
        }
        
        if(bcryptpasswordEncoder.matches(user.getUserPw(), dbUser.getUserPw())) {
            session.setAttribute("loginUser", dbUser);
            model.addAttribute("alertMsg", dbUser.getUserNm()+"님 환영합니다.");
            if("super".equals(dbUser.getUserId()))
                return "common/managePage";
            else
                return "common/userPage";
        }
        else {
            model.addAttribute("errorMsg","비밀번호가 다릅니다.");
            return "common/errorPage";
        }
        
	}
	
	@RequestMapping("logout.go")
	public String logout(HttpSession session,
	                     Model model) {
	    session.removeAttribute("loginUser");
	    model.addAttribute("alertMsg", "로그아웃");
	    return "redirect:/";
	}
	
    @RequestMapping("insertForm.user")
    public String goToInsertForm() {
        return "user/insertForm";
    }
    
	// 계정 등록
	@PostMapping("insert.user")
	public String insertUser(User user,
							HttpSession session,
							Model model) {
		
	    // 입력 확인
	    if(user.getUserId()==null || "".equals(user.getUserId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        if(user.getUserPw()==null || "".equals(user.getUserPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
        if(user.getUserChk()==null || "".equals(user.getUserChk())) {
            model.addAttribute("errorMsg","비밀번호 확인 다시 필요");
            return "common/errorPage";
        }
        if(user.getUserNm()==null || "".equals(user.getUserNm())) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
	    
	    
	    // 입력한 ID로 조회하여 중복 확인
        User dbUser = userService.selectUser(user.getUserId());
	    if(dbUser != null) {
	        model.addAttribute("errorMsg","이미 존재하는 ID");
            return "common/errorPage";
	    }
	    
		String encPw = bcryptpasswordEncoder.encode(user.getUserPw());
		
		user.setUserPw(encPw);
		
		int result = userService.insertUser(user);
		
		if(result>0) {
			session.setAttribute("alertMsg", "사용자 계정 추가 성공");
			return "common/managePage";
		}else {
			model.addAttribute("errorMsg","사용자 계정 추가 실패");
			
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateForm.user")
	public String goToUpdateForm() {
	    return "user/updateForm";
	}
	
    // 계정 정보 수정
	@RequestMapping("update.user")
    public String updateUser(User user,
                            HttpSession session,
                            Model model) {

        // 입력 확인
	    if(user.getUserId()==null || "".equals(user.getUserId())) {
	        model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
	    }
	    if(user.getUserPw()==null || "".equals(user.getUserPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
	    if(user.getUserNewPw()==null || "".equals(user.getUserNewPw())) {
            model.addAttribute("errorMsg","새 비밀번호 입력 필요");
            return "common/errorPage";
        }
	    if(user.getUserChk()==null || "".equals(user.getUserChk())) {
            model.addAttribute("errorMsg","새 비밀번호 확인 다시 입력");
            return "common/errorPage";
        }
	    
	    // 조회해서 비밀번호 같으면 수정
	    User dbUser = userService.selectUser(user.getUserId());
	    
        if( dbUser != null && bcryptpasswordEncoder.matches(user.getUserPw(), dbUser.getUserPw()) ) {
            
            
            if(user.getUserNewPw().equals(user.getUserChk())) {
                
                // 새 비밀번호를 암호화하여 다시 담기
                String encNewPw = bcryptpasswordEncoder.encode(user.getUserNewPw());
                user.setUserNewPw(encNewPw);
                
                int result = userService.updateUser(user);
                
                if(result>0) {
                    session.setAttribute("alertMsg", "수정 완료");
                    return "common/managePage";
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
	
	
    @RequestMapping("deleteForm.user")
    public String goToDeleteForm() {
        return "user/deleteForm";
    }
    
    @RequestMapping("delete.user")
    public String deleteUser(User user
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(user.getUserId()==null || "".equals(user.getUserId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        if(user.getUserPw()==null || "".equals(user.getUserPw())) {
            model.addAttribute("errorMsg","현재 비밀번호 입력 필요");
            return "common/errorPage";
        }
        
        // 조회해서 비밀번호 같으면 삭제
        User dbUser = userService.selectUser(user.getUserId());
        
        if( dbUser != null && bcryptpasswordEncoder.matches(user.getUserPw(), dbUser.getUserPw()) ) {

            int result = userService.deleteUser(user.getUserId());
            
            if(result>0) {
                session.setAttribute("alertMsg", "삭제 완료");
                return "common/managePage";
            }else {
                model.addAttribute("errorMsg","계정 삭제 실패");
                
                return "common/errorPage";
            }
        }
        
        model.addAttribute("errorMsg","비밀번호 불일치");
        return "common/errorPage";
        
    }
    

    @RequestMapping("selectForm.user")
    public String goToSelectForm() {
        return "user/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectUser.user",produces="application/json; charset=UTF-8")
    public String selectuser(String userId) {
        return new Gson().toJson(userService.selectUser(userId));
    }
    
    @ResponseBody
    @RequestMapping(value="selectUserList.user",produces="application/json; charset=UTF-8")
    public String selectUserList(HttpSession session, Model model) {
        return new Gson().toJson(userService.selectUserList());
    }
    
    
}
