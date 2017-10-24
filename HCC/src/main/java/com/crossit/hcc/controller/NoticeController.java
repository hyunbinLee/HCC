package com.crossit.hcc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.NoticeMapperImple;
import com.crossit.hcc.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeMapperImple noticeDao;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value = "/noticeList", method=RequestMethod.GET)
	public String noticeList(HttpSession session,Model model,
	         @RequestParam(value = "page", required = false) String page)
	{
		if(page == null) {
			page = "1";
		}
		
		model.addAttribute("page", page);		
		
		NoticeService pagingImpl = new NoticeService(page);
		
		
		int start = pagingImpl.getStart();
		int end = pagingImpl.getEnd();
		
		
		//전체 게시물 수
		pagingImpl.setNumberOfRecords(noticeDao.getNoticeCount());
		//마지막 페이지 번호
		
		pagingImpl.makePaging();
		
		model.addAttribute("startPage", pagingImpl.getStartPageNo());
		model.addAttribute("endPage", pagingImpl.getEndPageNo());
		model.addAttribute("fmb",noticeDao.getNoticeList(start, end));
		model.addAttribute("lastPage", pagingImpl.getFinalPageNo());

		return "board/noticeList_ajax";
	}
	
	
	@RequestMapping(value="/noticeWritePage", method=RequestMethod.GET)
	public String noticeWritePage(HttpSession session) {
		logger.info("공지사항 작성 페이지 {}", session.getId());

		
		return "board/writePage";
	}
	
	@RequestMapping(value="/noticeWrite", method=RequestMethod.GET)
	public String noticeWriteAction(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");

		logger.info("공지사항 작성 {}", session.getId());
		
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		noticeDao.writeNotice(title, content);
		
		return "redirect:noticeList?page=1";
	}
	
	
	@RequestMapping(value="/noticeContentPage", method=RequestMethod.GET)
	public String noticeContentPage(HttpSession session,HttpServletRequest request,Model model) {
		
		logger.info("공지사항 내용{}", session.getId());
		
		String seq = request.getParameter("seq");
		noticeDao.updateHit(seq);
		
		model.addAttribute("fmb", noticeDao.getNoticeContent(seq));
		
		return "board/noticeContentPage";
	}
	
	@RequestMapping(value ="/deleteNotice")
	public String deleteNoticeAcition(HttpSession session,HttpServletRequest request) {
		logger.info("공지사항 삭제{}", session.getId());
		
		String seq = request.getParameter("seq");
		noticeDao.deleteNotice(seq);
		
		return "redirect:noticeList?page=1";
	}
	
	@RequestMapping(value="/updateNoticePage")
	public String updateNoiticePage(HttpServletRequest request,Model model) {
	
		String seq = request.getParameter("seq");
		model.addAttribute("notice", noticeDao.getNoticeContent(seq));
		
		return "board/updatePage";
	}
	
	@RequestMapping(value="/updateNoitce")
	public String updateNoitce(HttpServletRequest request) throws Exception {
		
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		noticeDao.updateNotice(seq, title, content);
		
		return "redirect:noticeList?page=1";
	}
}
