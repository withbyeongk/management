package com.iron.management.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {


	@RequestMapping("home.go")
    public String goToHome() {
        return "redirect:/";
    }
	
	@RequestMapping("managePage.go")
	public String goToManage() {
	    return "common/managePage";
	}
	
	@RequestMapping("newManage.go")
	public String goToNewManagePage() {
		return "common/newManagePage";
	}
}
