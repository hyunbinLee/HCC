package com.crossit.hcc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crossit.hcc.service.UserDetail;

@Controller
public class ChattingController {

	@RequestMapping(value = "/chatting",method=RequestMethod.GET)
	public ModelAndView chat(ModelAndView mv){
		
		mv.setViewName("chat/chattingview");
		UserDetail user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		mv.addObject("userid",user.getUsername());
		return mv;
	}
	
}
