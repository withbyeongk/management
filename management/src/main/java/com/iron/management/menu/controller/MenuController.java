package com.iron.management.menu.controller;

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
import com.iron.management.menu.model.service.MenuService;
import com.iron.management.menu.model.vo.Menu;
import com.iron.management.site.model.vo.Site;

@Controller
public class MenuController {
    
    @Autowired
    private MenuService menuService;

    @Autowired
    private AdminService adminService;
    
    @RequestMapping("insertForm.mn")
    public String goToInsertForm() {
        return "menu/insertForm";
    }
    

    // 계정 등록
    @PostMapping("insert.mn")
    public String insertMenu(Menu menu,
                            HttpSession session,
                            Model model) {
        // 입력 확인
        if(menu.getMenuNm()==null || "".equals(menu.getMenuNm())) {
            model.addAttribute("errorMsg","메뉴명 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuUrl()==null || "".equals(menu.getMenuUrl())) {
            model.addAttribute("errorMsg","이동 URL 입력 필요");
            return "common/errorPage";
        }
        
        // 메뉴명 중복 확인
        Menu dbMenu = menuService.selectMenu(menu.getMenuNm());
        if(dbMenu != null) {
            model.addAttribute("errorMsg","이미 존재하는 메뉴명");
            return "common/errorPage";
        }
        
        int result = menuService.insertMenu(menu);
        
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
        System.out.println("UDPATE");
        System.out.println(menu);
        // 입력 확인
        if(menu.getMenuId()==0) {
            model.addAttribute("errorMsg","메뉴ID 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuNm()==null || "".equals(menu.getMenuNm())) {
            model.addAttribute("errorMsg","메뉴명 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuUrl()==null || "".equals(menu.getMenuUrl())) {
            model.addAttribute("errorMsg","이동 URL 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuRefId()==0) {
            model.addAttribute("errorMsg","상위 메뉴 ID 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuLevel()==0) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuOrder()==0) {
            model.addAttribute("errorMsg","이름 입력 필요");
            return "common/errorPage";
        }
        
        Menu beforeMenu = menuService.selectMenu(menu.getMenuId());
        System.out.println("beforeMenu"+beforeMenu);
        menu.setBeforeRefId(beforeMenu.getMenuRefId());
        menu.setBeforeLevel(beforeMenu.getMenuLevel());
        menu.setBeforeOrder(beforeMenu.getMenuOrder());

        System.out.println(menu);
        int result = menuService.updateMenu(menu);
        
        if(result>0) {
            session.setAttribute("alertMsg", "메뉴 수정 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","메뉴 수정 실패");
            return "common/errorPage";
        }
    }
    
    
    @RequestMapping("deleteForm.mn")
    public String goToDeleteForm() {
        return "menu/deleteForm";
    }
    
    @RequestMapping("delete.mn")
    public String deleteMenu(int menuId
                            , HttpSession session
                            , Model model) {
        System.out.println(menuId);
        // 입력 확인
        if(menuId==0) {
            model.addAttribute("errorMsg","ID 입력 필요");
            return "common/errorPage";
        }
        
        int result = menuService.deleteMenu(menuId);
        
        if(result > 0) {
            model.addAttribute("alertMsg", "메뉴 삭제 성공");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","메뉴 삭제 실패");
            return "common/errorPage";
        }
    }
    

    @RequestMapping("selectForm.mn")
    public String goToSelectForm() {
        return "menu/selectForm";
    }
    
    @ResponseBody
    @RequestMapping(value="selectMenu.mn",produces="application/json; charset=UTF-8")
    public String selectMenu(int menuId) {
        return new Gson().toJson(menuService.selectMenu(menuId));
    }
    
    @ResponseBody
    @RequestMapping(value="selectMenuList.mn",produces="application/json; charset=UTF-8")
    public String selectMenuList(HttpSession session, Model model) {
        return new Gson().toJson(menuService.selectMenuList());
    }
    

    @RequestMapping("accessForm.mn")
    public String goToAccessForm() {
        return "menu/accessForm";
    }
    
    @RequestMapping("grantAccess.mn")
    public String grantAccess(Menu menu
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(menu.getAdminId()==null || "".equals(menu.getAdminId())) {
            model.addAttribute("errorMsg","A ID 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuId()==0) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 중복 확인
        Admin dbAdmin = adminService.selectAdmin(menu.getAdminId());
        if(dbAdmin == null) {
            model.addAttribute("errorMsg","존재하는 ADMIN ID가 아님");
            return "common/errorPage";
        }
        
        Menu dbMenu = menuService.selectMenu(menu.getMenuId());
        if(dbMenu == null) {
            model.addAttribute("errorMsg","존재하는 메뉴ID가 아님");
            return "common/errorPage";
        }
        
        int result = menuService.grantAccess(menu);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 권한 부여 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 권한 부여 실패");
            
            return "common/errorPage";
        }
        
    }
    
    @RequestMapping("revokeAccess.mn")
    public String  revokeAccess(Menu menu
                            , HttpSession session
                            , Model model) {
        // 입력 확인
        if(menu.getAdminId()==null || "".equals(menu.getAdminId())) {
            model.addAttribute("errorMsg","A ID 입력 필요");
            return "common/errorPage";
        }
        if(menu.getMenuId()==0) {
            model.addAttribute("errorMsg","SITE ID 입력 필요");
            return "common/errorPage";
        }
        
        // 입력한 ID로 조회하여 중복 확인
        Admin dbAdmin = adminService.selectAdmin(menu.getAdminId());
        if(dbAdmin == null) {
            model.addAttribute("errorMsg","존재하는 ADMIN ID가 아님");
            return "common/errorPage";
        }
        
        Menu dbMenu = menuService.selectMenu(menu.getMenuId());
        if(dbMenu == null) {
            model.addAttribute("errorMsg","존재하는 메뉴ID가 아님");
            return "common/errorPage";
        }
        
        int result = menuService.revokeAccess(menu);
        
        if(result>0) {
            session.setAttribute("alertMsg", "사이트 권한 회수 완료");
            return "redirect:/";
        }else {
            model.addAttribute("errorMsg","사이트 권한 회수 실패");
            
            return "common/errorPage";
        }
        
    }
    
}
