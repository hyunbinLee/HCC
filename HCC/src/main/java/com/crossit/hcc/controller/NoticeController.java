package com.crossit.hcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.NoticeMapper;
import com.crossit.hcc.controller.LoginController;

@Controller
public class NoticeController {
	
	@Autowired
	SqlSession sqlSession;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value = "/noticeList", method=RequestMethod.GET)
	public String noticeList(HttpSession session,Model model, 
			@RequestParam(value = "block", required = false ) String block,
	         @RequestParam(value = "page", required = false) String page,
	         @RequestParam(value="word", required=false) String word)
	{
		logger.info("여기는 공지사항 리스트 {} 페이지 {}", page,session.getId());
		
		 // 현재 페이지 (사용자가 원하는 페이지)
	      int pageNumber = 0;
	      // 전체 페이지 수 
	      int pages = 0;
	      // 블록 내에 있는 유효 페이지 수     
	      int validPages = 0;
	      // 총 컨텐츠 수 
	      int allNotice = 0;
	      // 전체 블록 수
	      int blocks = 0;
	      // 현재 블록 (사용자가 원하는 블록)
	      int blockNumber = 0;
		
	      // 페이지 수 기본 세팅, 처음은 1 페이지로 고정
	      try {
	         pageNumber = Integer.parseInt(page);
	      } catch (NumberFormatException e) {
	         pageNumber = 1;
	      }

	      // 페이지 수에 따라 그 안에 있는 컨텐츠 가져오기
	      int start = (pageNumber - 1) * 10 + 1;
	      int end = pageNumber * 10;

	      NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
	      
	      
	      // 총 갯수 불러오기
	      String userId= (String)session.getAttribute("LoginOk");
	      allNotice= dao.getNoticeCount();

	      // 페이지에 맞는 컨텐츠 불러 오기


	      model.addAttribute("list",dao.getNoticeList(start, end));

	      // 전체 페이지 수
	      if (allNotice < 10) {
	         pages = 1;
	      } else if (allNotice % 10 == 0) {
	         pages = allNotice / 10;
	      } else {
	         pages = allNotice / 10+1;
	      }

	      // 전체 블록 수
	      if (pages < 10) {
	         blocks = 1;
	      } else if (pages % 10 == 0) {
	         blocks = pages / 10;
	      } else {
	         blocks = pages / 10+1;
	      }

	      model.addAttribute("blocks", blocks);

	      // 블럭 기본 세팅, 처음은 첫번째 블럭로 고정
	      try {
	         blockNumber = Integer.parseInt(block);
	      } catch (NumberFormatException e) {
	         blockNumber = 1;
	      }

	      model.addAttribute("block", blockNumber);

	      // 블록 안에 있는 유효 페이지 수 세기
	      // 블록이 마지막 블록이면 나머지가 유효 페이지
	      // 마지막 블록이 아니면 10 페이지
	      // 단 나머지가 0인 경우 주의할 것. 이럴 경우 유효 페이지는 10 페이지
	      if (blocks == 1) {
	        validPages = pages;
	      } else if (blocks == blockNumber) {
	         validPages = (blockNumber % 10 == 0) ? 10 : blockNumber % 10;
	      } else {
	         validPages = 10;
	      }
	      model.addAttribute("pages", pages);
	      
	      return "board/noticeList_ajax";
	}
	
	@RequestMapping(value="/noticeWritePage", method=RequestMethod.GET)
	public String noticeWritePage(HttpSession session) {
		logger.info("공지사항 작성 페이지 {}", session.getId());

		
		return "board/writePage";
	}
	
	@RequestMapping(value="/noticeWrite", method=RequestMethod.GET)
	public String noticeWriteAction(HttpSession session,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		logger.info("공지사항 작성 {}", session.getId());
		
		NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		dao.writeNotice(title, content);
		
		return "redirect:noticeList?page=1";
	}
	
	@RequestMapping(value="/noticeContentPage", method=RequestMethod.GET)
	public String noticeContentPage(HttpSession session,HttpServletRequest request,Model model) {
		
		logger.info("공지사항 내용{}", session.getId());
		
		String seq = request.getParameter("seq");
		NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
		model.addAttribute("notice", dao.getNoticeContent(seq));
		
		return "board/noticeContentPage";
	}
	
	@RequestMapping(value ="/deleteNotice")
	public String deleteNoticeAcition(HttpSession session,HttpServletRequest request) {
		logger.info("공지사항 삭제{}", session.getId());
		
		String seq = request.getParameter("seq");
		NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
		dao.deleteNotice(seq);
		
		return "redirect:noticeList?page=1";
	}
	
	@RequestMapping(value="/updateNoticePage")
	public String updateNoiticePage(HttpServletRequest request,Model model) {
	
		String seq = request.getParameter("seq");
		NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
		model.addAttribute("notice", dao.getNoticeContent(seq));
		
		return "board/updatePage";
	}
	
	@RequestMapping(value="/updateNoitce")
	public String updateNoitce(HttpServletRequest request) throws Exception {
		
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		
		NoticeMapper dao = sqlSession.getMapper(NoticeMapper.class);
		dao.updateNotice(seq, title, content);
		
		return "redirect:noticeList?page=1";
	}
}
