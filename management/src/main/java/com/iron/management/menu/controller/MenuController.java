package com.iron.management.menu.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iron.management.admin.model.vo.Admin;
import com.iron.management.menu.model.service.MenuService;
import com.iron.management.menu.model.vo.Menu;

@Controller
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("insertForm.mn")
    public String goToInsertForm() {
        return "menu/insertForm";
    }
    

    // 계정 등록
    @PostMapping("insert.mn")
    public String insertMenu(String menuNm,
                            HttpSession session,
                            Model model) {
        
        // 입력 확인
        if(menuNm==null || "".equals(menuNm)) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        if(menuNm==null || "".equals(menuNm)) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        if(menuNm==null || "".equals(menuNm)) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        if(menuNm==null || "".equals(menuNm)) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        if(menuNm==null || "".equals(menuNm)) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        
        
        // 입력한 ID로 조회하여 중복 확인
        Menu dbMenu = menuService.selectMenu(menuNm);
        if(dbMenu != null) {
            model.addAttribute("errorMsg","이미 존재하는 메뉴명");
            return "common/errorPage";
        }
        
        int result = menuService.insertMenu(menuNm);
        
        if(result>0) {
            session.setAttribute("alertMsg", "메뉴 등록 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","메뉴 등록 실패");
            return "common/errorPage";
        }
    }
    
    @RequestMapping("updateForm.mn")
    public String goToUpdateForm() {
        return "menu/updateForm";
    }
    
    // 계정 정보 수정
    @RequestMapping("update.mn")
    public String updateMenu(Menu menu,
                            HttpSession session,
                            Model model) {

        // 입력 확인
        /*
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
        }*/
        
        // 조회해서 비밀번호 같으면 수정
        /*
        Admin dbMenu = menuService.selectMenu(menu.getMenuId());
        
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
        */
        model.addAttribute("errorMsg","비밀번호 불일치");
        return "common/errorPage";
    }
    
    
    @RequestMapping("deleteForm.mn")
    public String goToDeleteForm() {
        return "admin/deleteForm";
    }
    
    @RequestMapping("delete.mn")
    public String deleteMenu(Admin adm
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        /*
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
        */
        model.addAttribute("errorMsg","비밀번호 불일치");
        return "common/errorPage";
        
    }
    

    @RequestMapping("selectForm.mn")
    public String goToSelectForm() {
        return "admin/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectMenu.mn",produces="application/json; charset=UTF-8")
    public String selectAdmin(String menuNm) {
        return new Gson().toJson(menuService.selectMenu(menuNm));
    }
    
    @ResponseBody
    @RequestMapping(value="selectMenuList.mn",produces="application/json; charset=UTF-8")
    public String selectMenuList(HttpSession session, Model model) {
        ArrayList<Menu> list = menuService.selectMenuList();
        return new Gson().toJson(list);
    }
    
}
