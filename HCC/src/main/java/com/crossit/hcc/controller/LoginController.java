package com.crossit.hcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.dao.NoticeMapperImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Autowired
	private BoardMapperImpl boardDao;
	@Autowired
	private NoticeMapperImpl noticeDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String login(HttpSession session,Model model) {
		logger.info("Welcome login! {}", session.getId());
		int start=1,end=5;
		
		model.addAttribute("fmb",boardDao.getfmbList(start, end));
		model.addAttribute("notice",noticeDao.getNoticeList(start, end));
		return "main";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.POST)
	public String denied(Model model, Authentication auth, HttpServletRequest req) {
		
		System.out.println("권한없음");
		return "denied";
	}
	
	
}
