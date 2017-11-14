package com.crossit.hcc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
public class UserLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest req,
                                HttpServletResponse res,
                                Authentication auth)
            throws java.io.IOException, javax.servlet.ServletException {
    	final Logger logger = LoggerFactory.getLogger(UserLogoutSuccessHandler.class);
    	
		logger.info("Welcome goobye! {}");

	    res.sendRedirect("/hcc/main");
    }
}
