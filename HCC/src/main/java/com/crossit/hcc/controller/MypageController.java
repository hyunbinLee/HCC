package com.crossit.hcc.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossit.hcc.dao.NoticeMapper;
import com.crossit.hcc.service.UserDetail;

@Controller
public class MypageController {

	@Autowired
	private NoticeMapper noticeDao;
	
	@RequestMapping(value = "/myPage", method=RequestMethod.GET)
	public String myPage(Model model)
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		String user_seq = "" + userdetail.getUser().getUser_seq();
		
		model.addAttribute("List",noticeDao.getNoticeContentByUserSeq(user_seq));

		model.addAttribute("List_L",noticeDao.getLikeNoticeContentByUserSeq(user_seq));

		return "mypage/myPage";
	}
	

}
