package com.crossit.hcc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.AdminMapperImple;
import com.crossit.hcc.service.AdminService;

@Controller
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
	
	@RequestMapping(value="/userInfo")
	public String UserInfo(HttpSession session, Model model,
			@RequestParam(value = "id",required = false) String id) {
		
		model.addAttribute("user", adminDao.getUserInfo(id));
		
		return "/admin/userInfo";
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(HttpSession session, Model model,
			@RequestParam(value = "id",required = false) String id) {
		
		adminDao.deleteUser(id);
		
		return "redirect:memberManagement";
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public String changePassword(HttpSession session,Model model,
			@RequestParam(value = "id",required = false) String id,
			@RequestParam(value = "newPassword",required = false) String password) {
		
		adminDao.changePassword(id,password);
		
		return "redirect:memberManagement";
	}
}
