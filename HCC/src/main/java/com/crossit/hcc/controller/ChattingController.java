package com.crossit.hcc.controller;

import java.util.ArrayList;
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

	@RequestMapping(value = "/chatting", method = RequestMethod.POST)
	public ModelAndView chat(ModelAndView mv, @RequestParam String s_userid) {

		mv.setViewName("chat/chattingview");
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mv.addObject("userid", user.getUsername());
		mv.addObject("s_userid", s_userid);

		return mv;
	}

	@RequestMapping(value = "/loginuserlist", method = RequestMethod.GET)
	public ModelAndView loginuserlist(ModelAndView mv) {

		mv.setViewName("chat/userchoiceview");

		List<SessionInformation> result = s_handler.getAllSessions();// 모든 유저 목록  받아오기
		ArrayList<String> userList = new ArrayList<String>();
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		for (int i = 0; i < result.size(); i++) {

			UserDetail tmp = (UserDetail) result.get(i).getPrincipal();

			if (tmp.getUsername().equals(user.getUsername()))// 자기 자신을 빼고 리스트에 넣기.
				continue;

			userList.add(tmp.getUsername());
		}

		mv.addObject("currentuserid", user.getUsername());

		if (userList.size()==0)
			mv.addObject("userList", null);
		else
			mv.addObject("userList", userList);

		return mv;
	}

}
