package com.crossit.hcc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.AdminMapperImpl;
import com.crossit.hcc.service.PagingService;

@Controller
public class AdminController {

	@Autowired
	private AdminMapperImpl adminDao;
	
	private PagingService pagingService;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping(value = "/memberManagement")
	public String memberManagement(HttpSession session,Model model,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "kind", required = false) String kind) 
	{
		if(page != null) {
			model.addAttribute("page", page);
		}else {
			model.addAttribute("page", "1");
		}
		
		String userKind;
		if(kind != null) {
			userKind = kind;
		}else {
			userKind = "U";
		}
		
		//회원 10명
		pagingService = new PagingService(10);

		int userCount = adminDao.getUserCount(userKind);
		pagingService.paging(page,userCount);
		
		
		
		model.addAttribute("startPage", pagingService.startPageNo());
		model.addAttribute("endPage", pagingService.endPageNo());
		model.addAttribute("list", adminDao.getUserList(pagingService.getStart(), pagingService.getEnd(), userKind));
		model.addAttribute("lastPage", pagingService.getFinalPageNo());
		
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
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassword(HttpSession session,Model model,
			@RequestParam(value = "id",required = false) String id,
			@RequestParam(value = "newPassword",required = false) String password) {
		
		logger.info("{} 비밀번호 변경 : {}", id ,session.getId());

		
		
		adminDao.changePassword(id, password);
		
		return "redirect:memberManagement";
	}
}
