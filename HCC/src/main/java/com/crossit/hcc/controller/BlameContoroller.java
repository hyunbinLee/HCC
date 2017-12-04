package com.crossit.hcc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.BlameMapper;
import com.crossit.hcc.service.PagingService;
import com.crossit.hcc.service.PagingServiceImpl;
import com.crossit.hcc.service.UserDetail;

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
	
//	@RequestMapping(value="/blamePopup")
//	public String blamePopup(HttpServletRequest request) {
//		
//		String blame_gubun = request.getParameter("gubun");
//		String blame_code = request.getParameter("code");
//		
//		System.out.println(blame_code);
//		
//		return "/blame/blamePopup?code=1"+blame_code+"&gubun="+blame_gubun;
//	}
	
	@RequestMapping(value="blamePopup")
	public String blamePopup() {
		
		return "blame/blamePopup";
	}
	
	
	@RequestMapping(value="/Declaration")
	public String DeclarationAction(HttpServletRequest request,HttpSession session, Model model
			) throws UnsupportedEncodingException 
	{
		request.setCharacterEncoding("utf-8");
		
		String blame_code = request.getParameter("code");
		String blame_gubun = request.getParameter("gubun");
		char blame_type = request.getParameter("type").charAt(0);
		
		String blame_content = request.getParameter("content");
		blame_content = new String(blame_content.getBytes("8859_1"),"utf-8");
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
	    
	    String blame_reg_seq = "" + userdetail.getUser().getUser_seq();
		
		blameDao.insertBlameList(blame_code, blame_gubun, blame_type, blame_content, blame_reg_seq);
		
		return "/blame/blameOK";
	}
}
