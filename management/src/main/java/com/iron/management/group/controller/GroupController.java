package com.iron.management.group.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iron.management.group.model.service.GroupService;
import com.iron.management.group.model.vo.Group;
import com.iron.management.site.model.vo.Site;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping("insertForm.group")
    public String goToInsertForm() {
        return "group/insertForm";
    }
    
	// 계정 등록
	@PostMapping("insert.group")
	public String insertGroup(Group group,
							HttpSession session,
							Model model) {
		
	    // 입력 확인
	    if(group.getGroupId()==null || "".equals(group.getGroupId())) {
            model.addAttribute("errorMsg","그룹ID 입력 필요");
            return "common/errorPage";
        }
        if(group.getGroupNm()==null || "".equals(group.getGroupNm())) {
            model.addAttribute("errorMsg","그룹명 입력 필요");
            return "common/errorPage";
        }
	    
	    // 입력한 ID로 조회하여 중복 확인
        Group dbGroup = groupService.selectGroup(group.getGroupId());
	    if(dbGroup != null) {
	        model.addAttribute("errorMsg","이미 존재하는 ID");
            return "common/errorPage";
	    }
	    
		int result = groupService.insertGroup(group);
		
		if(result>0) {
			session.setAttribute("alertMsg", "그룹 추가 성공");
			return "common/managePage";
		}else {
			model.addAttribute("errorMsg","사용자 계정 추가 실패");
			
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateForm.group")
	public String goToUpdateForm() {
	    return "group/updateForm";
	}
	
    // 계정 정보 수정
	@RequestMapping("update.group")
    public String updateGroup(Group group,
                            HttpSession session,
                            Model model) {

        // 입력 확인
	    if(group.getGroupId()==null || "".equals(group.getGroupId())) {
	        model.addAttribute("errorMsg","그룹 ID 입력 필요");
            return "common/errorPage";
	    }
	    if(group.getGroupNm()==null || "".equals(group.getGroupNm())) {
            model.addAttribute("errorMsg","그룹명 입력필요");
            return "common/errorPage";
        }
	    
	    // 입력한 ID로 조회하여 중복 확인
        Group dbGroup = groupService.selectGroup(group.getGroupId());
        if(dbGroup == null) {
            model.addAttribute("errorMsg","존재하는 그룹ID가 아님");
            return "common/errorPage";
        }
	    
	    int result = groupService.updateGroup(group);
        
        if(result>0) {
            session.setAttribute("alertMsg", "그룹 수정 완료");
            return "common/managePage";
        }else {
            model.addAttribute("errorMsg","그룹정보 수정 실패");
            
            return "common/errorPage";
        }
    }
	
	
    @RequestMapping("deleteForm.group")
    public String goToDeleteForm() {
        return "group/deleteForm";
    }
    
    @RequestMapping("delete.group")
    public String deleteAdmin(Group group
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(group.getGroupId()==null || "".equals(group.getGroupId())) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }

        // 입력한 ID로 조회하여 중복 확인
        Group dbGroup = groupService.selectGroup(group.getGroupId());
        if(dbGroup == null) {
            model.addAttribute("errorMsg","존재하는 그룹ID가 아님");
            return "common/errorPage";
        }
        
        int result = groupService.deleteGroup(group.getGroupId());
        
        if(result>0) {
            session.setAttribute("alertMsg", "그룹 삭제 완료");
            return "common/managePage";
        }else {
            model.addAttribute("errorMsg","그룹 삭제 실패");
            
            return "common/errorPage";
        }
        
    }
    

    @RequestMapping("selectForm.group")
    public String goToSelectForm() {
        return "group/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectUser.group",produces="application/json; charset=UTF-8")
    public String selectGroup(String groupId) {
        return new Gson().toJson(groupService.selectGroup(groupId));
    }
    
    @ResponseBody
    @RequestMapping(value="selectGroupList.group",produces="application/json; charset=UTF-8")
    public String selectGroupList(HttpSession session, Model model) {
        return new Gson().toJson(groupService.selectGroupList());
    }
    
    
}
