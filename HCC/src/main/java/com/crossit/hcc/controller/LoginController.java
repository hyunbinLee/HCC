package com.crossit.hcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String login(HttpSession session) {
		logger.info("Welcome login! {}", session.getId());
		return "main";
	}


//	@RequestMapping(value = "/login_success", method = RequestMethod.GET)
//	public String login_success(HttpSession session) {
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		UserDetail ud = (UserDetail) auth.getPrincipal();
//		UserVO uv = ud.getUser();
//		logger.info("Welcome login_success! {}, {}", uv.getUser_id(), session.getId());
//
//		return "main";
//	}

	@RequestMapping(value = "/denied", method = RequestMethod.POST)
	public String denied(Model model, Authentication auth, HttpServletRequest req) {
		
		System.out.println("권한없음");
		return "denied";
	}
	
	
}
