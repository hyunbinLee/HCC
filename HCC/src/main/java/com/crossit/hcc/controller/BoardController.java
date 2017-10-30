package com.crossit.hcc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.service.BoardService;
import com.crossit.hcc.service.UserDetail;
import com.crossit.hcc.util.PageNavigation;
import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.UserVO;;

@Controller
public class BoardController {

	
	@Autowired
	private BoardMapperImpl boardDao;
	
	@RequestMapping(value = "/fmbList", method=RequestMethod.GET)
	public String fmbList(HttpSession session,Model model,
	         @RequestParam(value = "page", required = false) String page)
	{
		model.addAttribute("page", page);		
		
		BoardService pagingImpl = new BoardService(page);
		
		int start = pagingImpl.getStart();
		int end = pagingImpl.getEnd();
		
		//전체 게시물 수
		pagingImpl.setNumberOfRecords(boardDao.getfmbCount());
		//마지막 페이지 번호
		
		pagingImpl.makePaging();
		
		model.addAttribute("startPage", pagingImpl.getStartPageNo());
		model.addAttribute("endPage", pagingImpl.getEndPageNo());
		model.addAttribute("fmb",boardDao.getfmbList(start, end));
		model.addAttribute("lastPage", pagingImpl.getFinalPageNo());

		return "board/fmbList_ajax";
	}
	
	@RequestMapping(value="/fmbWritePage", method=RequestMethod.GET)
	public String fmbWritePage(HttpSession session) {
		
		return "board/fmb_writePage";
	}
	
	@RequestMapping(value="/fmbWrite", method=RequestMethod.GET)
	public String fmbWriteAction(HttpSession session,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail vo = (UserDetail)auth.getPrincipal();
	      
	    UserVO v1 = vo.getUser();
	    int user_seq = v1.getUser_seq();
		String type = request.getParameter("select");
		String status = request.getParameter("status");
		
		boardDao.writefmb(title, content,user_seq,type,status);
		
		return "redirect:fmbList?page=1";
	}
	
	@RequestMapping(value="/fmbContentPage", method=RequestMethod.GET)
	public String fmbContentPage(HttpSession session,HttpServletRequest request,Model model) {
		String seq = request.getParameter("seq");
		boardDao.updateHit(seq); //조회수 증가
		
		model.addAttribute("fmb", boardDao.getfmbContent(seq));
		
		
		return "board/fmbContentPage";
	}
	
	@RequestMapping(value ="/deleteList")
	public String deleteListAction(HttpSession session,HttpServletRequest request) {
		String seq = request.getParameter("seq");
		boardDao.deleteList(seq);
		
		return "redirect:fmbList?page=1";
	}
	
	@RequestMapping(value ="/likeList")
	public String likeList(HttpSession session,HttpServletRequest request) {
		String seq = request.getParameter("seq");
		boardDao.likeList(seq);
		
		return "redirect:fmbContentPage?seq=" + seq;
	}
	@RequestMapping(value ="/unlikeList")
	public String unlikeList(HttpSession session,HttpServletRequest request) {
		String seq = request.getParameter("seq");
		boardDao.unlikeList(seq);
		
		return "redirect:fmbContentPage?seq=" + seq;
	}
	
	@RequestMapping(value="/updateListPage")
	public String updateListPage(HttpServletRequest request,Model model) {
	
		String seq = request.getParameter("seq");
		model.addAttribute("fmb", boardDao.getfmbContent(seq));
		
		return "board/update_fmbPage";
	}
	
	@RequestMapping(value="/updateList")
	public String updateList(HttpServletRequest request) throws Exception {
		
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		boardDao.updateList(seq, title, content);
		
		return "redirect:fmbList?page=1";
	}
	@RequestMapping(value = "/showboard", method = RequestMethod.GET)
	public String register(@RequestParam int pages, @RequestParam int lines, Model model) {

		String url = "";
		PageNavigation paging = new PageNavigation(pages, lines);
		
		/////오류?
		BoardService service = new BoardService();
		int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();
		List<BoardVO> bookList = service.selectRecordsPerPage(offset, paging.getRecordsPerPage());

		paging.setNumberOfRecords(service.getBoardDao().getNoOfRecords());

		// 페이징 만듦
		paging.makePaging();

		// 게시판 리스트가 존재할 경우
		if (bookList != null) {
			model.addAttribute("bookList", bookList);
			model.addAttribute("paging", paging);
			model.addAttribute("servletPath", "BoardCheckOutAdmin");

			url = "show_board_list";//게시판 리스트 보여줄 곳 이동
		}
		// list가 존재하지 않을 경우
		else {
			model.addAttribute("msg", "Error 가 발생했습니다.");

			url = "error_msg";
		}

		return url;
	}

}
