package com.crossit.hcc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.BlameMapper;
import com.crossit.hcc.service.PagingService;
import com.crossit.hcc.service.PagingServiceImpl;

@Controller
public class BlameContoroller {
	
	@Autowired
	private BlameMapper blameDao;
	
	private PagingService pagingService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping(value="/blameList")
	public String BlameList(HttpSession session,Model model
			,@RequestParam(value = "page", required = false) String page) {
		if(page != null) {
			model.addAttribute("page", page);
		}else {
			model.addAttribute("page", "1");
		}
		
		pagingService = new PagingServiceImpl(20);
		
		//회원 10명
		pagingService = new PagingServiceImpl(10);

		int blameCount = blameDao.getBlameCount();
		pagingService.paging(page,blameCount);
		
		model.addAttribute("startPage", pagingService.startPageNo());
		model.addAttribute("endPage", pagingService.endPageNo());
		model.addAttribute("list", blameDao.getBlameList(pagingService.getStart(), pagingService.getEnd()));
		model.addAttribute("lastPage", pagingService.getFinalPageNo());
		
		return "/blame/blameList";
	}
	
	@RequestMapping(value="/Declaration")
	public String DeclarationAction(HttpSession session, Model model) {
		
		
		
		
		return "redirect";
	}
}
