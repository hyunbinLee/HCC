package com.crossit.hcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crossit.hcc.service.UserDetail;
import com.crossit.hcc.util.SessionHandler;

@Controller
public class ChattingController {
	
	
	@Autowired
	private SessionHandler s_handler;
	
	@RequestMapping(value = "/chatting",method=RequestMethod.POST)
	public ModelAndView chat(ModelAndView mv,@RequestParam String s_userid){
		
		mv.setViewName("chat/chattingview");
		UserDetail user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		mv.addObject("userid",user.getUsername());
		return mv;
	}
	
	@RequestMapping(value = "/loginuserlist",method=RequestMethod.GET)
	public ModelAndView loginuserlist(ModelAndView mv){
		
		mv.setViewName("chat/userchoiceview");
		
		List<SessionInformation> result = s_handler.getAllSessions();
		String [] userList = new String[result.size()];
		
		for(int i=0; i<result.size();i++){
		UserDetail user = (UserDetail) result.get(i).getPrincipal();
		userList[i]=user.getUsername();
		}
		
		
		mv.addObject("userList", userList);
		return mv;
	}

}
