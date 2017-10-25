package com.crossit.hcc.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.crossit.hcc.vo.UserVO;


public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	
	UserVO vo;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		
		
		 res.sendRedirect("/hcc/main");
	}
	
	
}