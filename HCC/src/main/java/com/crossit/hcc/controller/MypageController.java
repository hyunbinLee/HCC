package com.crossit.hcc.controller;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.util.PageNavigation;

@Controller
public class MypageController {

	@Autowired
	//private BoardMapperImpl boardDao;
	
	@RequestMapping(value = "/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session)
	{
//		model.addAttribute("page", page);		
//		
//		BoardService pagingImpl = new BoardService(page);
//		
//		int start = pagingImpl.getStart();
//		int end = pagingImpl.getEnd();
//		
//		//전체 게시물 수
//		pagingImpl.setNumberOfRecords(boardDao.getfmbCount());
//		//마지막 페이지 번호
		
//		pagingImpl.makePaging();
		
//		model.addAttribute("startPage", pagingImpl.getStartPageNo());
//		model.addAttribute("endPage", pagingImpl.getEndPageNo());
//		model.addAttribute("fmb",boardDao.getfmbList(start, end));
//		model.addAttribute("lastPage", pagingImpl.getFinalPageNo());

		return "mypage/myPage";
	}
	

}
