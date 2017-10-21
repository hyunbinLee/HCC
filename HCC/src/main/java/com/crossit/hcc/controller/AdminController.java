package com.crossit.hcc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.AdminMapperImple;
import com.crossit.hcc.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminMapperImple adminDao;

	
	@RequestMapping(value = "/memberManagement")
	public String memberManagement(HttpSession session,Model model,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "kind", required = false) String kind) 
	{
		model.addAttribute("page", page);
		
		AdminService service = new AdminService(page);
		
		int start = service.getStart();
		int end = service.getEnd();
		
		String userKind;
		if(kind != null) {
			userKind = kind;
		}else {
			userKind = "U";
		}
		
		model.addAttribute("list", adminDao.getUserList(start, end, userKind));
		
		service.setNumberOfRecords(adminDao.getUserCount(userKind)); //총 회원수
		
		service.makePage();
		
		model.addAttribute("startPage", service.getStartPage());
		model.addAttribute("endPage", service.getEndPage());
		model.addAttribute("lastPage", service.getFinalPageNo());
		
		return "/admin/memberManagement";
	}
	
}
