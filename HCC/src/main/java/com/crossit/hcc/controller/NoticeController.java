package com.crossit.hcc.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.NoticeMapper;
import com.crossit.hcc.service.PagingService;
import com.crossit.hcc.service.PagingServiceImpl;
import com.crossit.hcc.service.UserDetail;
import com.crossit.hcc.vo.NoticeVO;

@Controller
public class NoticeController {
	

	@Autowired
	private NoticeMapper noticeDao;
	
	
	private PagingService pagingService;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value = "/noticeList", method=RequestMethod.GET)
	public String noticeList(HttpSession session,Model model,
	         @RequestParam(value = "page", required = false) String page)
	{
		if(page != null) {
			model.addAttribute("page", page);
		}else {
			model.addAttribute("page", "1");
		}
		
		//페이지당 5개의 글
		pagingService = new PagingServiceImpl(5);

		int noticeCount = noticeDao.getNoticeCount();
		pagingService.paging(page,noticeCount);
		
		
		model.addAttribute("hitsList",noticeDao.getNoticeHitsList());
		model.addAttribute("startPage", pagingService.startPageNo());
		model.addAttribute("endPage", pagingService.endPageNo());
		model.addAttribute("fmb",noticeDao.getNoticeList(pagingService.getStart(), pagingService.getEnd()));
		model.addAttribute("lastPage", pagingService.getFinalPageNo());

		return "notice/noticeList_ajax";
	}
	
	
	
	@RequestMapping(value = "/myNoticeList", method=RequestMethod.GET)//11.24 더보기 화면 구현 - 현빈
	public String myNoticeList(HttpSession session,Model model){
	
		model.addAttribute("page", "1");
		//페이지당 5개의 글
		pagingService = new PagingServiceImpl(5);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		String user_seq = "" + userdetail.getUser().getUser_seq();
		
		ArrayList<NoticeVO> myList = (ArrayList<NoticeVO>) noticeDao.getNoticeContentByUserSeq(user_seq);
		pagingService.paging("1",myList.size());
		
		
		
		model.addAttribute("startPage", pagingService.startPageNo());
		model.addAttribute("endPage", pagingService.endPageNo());
		model.addAttribute("fmb",myList);
		model.addAttribute("lastPage", pagingService.getFinalPageNo());

		return "notice/noticeList_ajax";
	}
	
	@RequestMapping(value = "/myLikeNoticeList", method=RequestMethod.GET)//11.24 더보기 화면 구현 - 현빈
	public String myLikeNoticeList(HttpSession session,Model model){
	
		model.addAttribute("page", "1");
		//페이지당 5개의 글
		pagingService = new PagingServiceImpl(5);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		String user_seq = "" + userdetail.getUser().getUser_seq();
		
		ArrayList<NoticeVO> myList = (ArrayList<NoticeVO>) noticeDao.getLikeNoticeContentByUserSeq(user_seq);
		pagingService.paging("1",myList.size());		

		model.addAttribute("startPage", pagingService.startPageNo());
		model.addAttribute("endPage", pagingService.endPageNo());
		model.addAttribute("fmb",myList);
		model.addAttribute("lastPage", pagingService.getFinalPageNo());

		return "notice/noticeList_ajax";
	}
	
	
	@RequestMapping(value="/noticeWritePage", method=RequestMethod.GET)
	public String noticeWritePage(HttpSession session) {
		logger.info("공지사항 작성 페이지 {}", session.getId());

		
		return "notice/writePage";
	}
	
	@RequestMapping(value="/noticeWrite", method=RequestMethod.GET)
	public String noticeWriteAction(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");

		logger.info("공지사항 작성 {}", session.getId());
		
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		System.out.println(title);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		
		
		noticeDao.writeNotice(title, content,userdetail.getUser().getUser_seq());
		
		return "redirect:noticeList?page=1";
	}
	
	
	@RequestMapping(value="/noticeContentPage", method=RequestMethod.GET)
	public String noticeContentPage(HttpSession session,HttpServletRequest request,Model model) {
		
		logger.info("공지사항 내용{}", session.getId());
		
		String seq = request.getParameter("seq");
		noticeDao.updateHit(seq);
		
		model.addAttribute("fmb", noticeDao.getNoticeContent(seq));
		
		String like_unlike_seq = request.getParameter("seq");
		String like_unlike_code = request.getParameter("code");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		
		String like_unlike_reg_seq = "" + userdetail.getUser().getUser_seq();
		
		//좋아요 상태 확인
		boolean likeStatus = false;
		if(noticeDao.checkLike(like_unlike_seq, like_unlike_code, like_unlike_reg_seq) != null) {
			likeStatus = true;
		}
		model.addAttribute("likeStatus", likeStatus);
		
		//싫어요 상태 확인
		boolean unlikeStatus = false;
		if(noticeDao.checkUnlike(like_unlike_seq, like_unlike_code, like_unlike_reg_seq) != null) {
			unlikeStatus = true;
		}
		
		model.addAttribute("unlikeStatus", unlikeStatus);
		
		return "notice/noticeContentPage";
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
		
		return "notice/updatePage";
	}
	
	@RequestMapping(value="/updateNotice")
	public String updateNoitce(HttpServletRequest request) throws Exception {
		
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		noticeDao.updateNotice(seq, title, content);
		
		return "redirect:noticeList?page=1";
	}
	
	
	@RequestMapping(value="/likeAction", method=RequestMethod.GET)
	public String like(HttpServletRequest request)
	{
		String like_seq = request.getParameter("seq");
		String like_code = request.getParameter("code");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		
		String like_reg_seq = "" + userdetail.getUser().getUser_seq();
		
		noticeDao.addLikeList(like_seq, like_code, like_reg_seq);
		noticeDao.updateNoticeLike(like_seq);
		
		
		return "redirect:noticeContentPage?seq="+like_seq+"&code=1&regSeq=11";
	}
	
	@RequestMapping(value="/unlikeAction", method=RequestMethod.GET)
	public String unlike(HttpServletRequest request)
	{
		String unlike_seq = request.getParameter("seq");
		String unlike_code = request.getParameter("code");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		
		String unlike_reg_seq = "" + userdetail.getUser().getUser_seq();
		
		
		noticeDao.addUnlikeList(unlike_seq, unlike_code, unlike_reg_seq);
		noticeDao.updateNoticeUnlike(unlike_seq);
		
		return "redirect:noticeContentPage?seq="+unlike_seq+"&code=1&regSeq=11";
	}
	
//	@RequestMapping(value = "/topofhits", method=RequestMethod.GET)
//	public String topOfHits(Model model)
//	{
//		List<NoticeVO> vo = noticeDao.getNoticeHitsList();
//		for(int i = 0 ; i<3; i++)
//		System.out.println(vo.get(i).getNotice_cnt());
//		model.addAttribute("hitsList",noticeDao.getNoticeHitsList());
//		
//		return "notice/noticeList_ajax";
//	}
}
