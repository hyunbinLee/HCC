package com.crossit.hcc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.dao.NoticeMapper;


/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Autowired
	private BoardMapperImpl boardDao;
	
	@Autowired
	private NoticeMapper noticeDao;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpSession session,Model model) {
		logger.info("Welcome index! {}", session.getId());
	
		return "redirect:main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String login(HttpSession session,Model model) {
		//logger.info("Welcome login! {}", session.getId());
		
		int start=1,end=5;
		model.addAttribute("fmb",boardDao.getfmbList(start, end));
		model.addAttribute("notice",noticeDao.getNoticeList(start, end));
		return "main";
	}

	
	
	
}
