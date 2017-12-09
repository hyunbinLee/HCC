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
	
	private BoardService service;
	
	@RequestMapping(value = "/fmbList", method=RequestMethod.GET)
	public String fmbList(HttpSession session,Model model,
	         @RequestParam(value = "page", required = false) String page)
	{
		model.addAttribute("page", page);		
		
		BoardService pagingImpl = new BoardService(page);
		
		int start = pagingImpl.getStart();
		int end = pagingImpl.getEnd();
		
		//�쟾泥� 寃뚯떆臾� �닔
		pagingImpl.setNumberOfRecords(boardDao.getfmbCount());
		//留덉�留� �럹�씠吏� 踰덊샇
		
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
//	public String fmbWriteAction(HttpSession session,HttpServletRequest request) throws Exception {
//		request.setCharacterEncoding("utf-8");
//
//		return service.fmbWriteAction(session, request);
//	}
	
	@RequestMapping(value="/fmbContentPage", method=RequestMethod.GET)
	public String fmbContentPage(HttpSession session,HttpServletRequest request,Model model) {
		String seq = request.getParameter("seq");
		boardDao.updateHit(seq); //議고쉶�닔 利앷�
		
		model.addAttribute("fmb", boardDao.getfmbContent(seq));
		model.addAttribute("reply", boardDao.getReplyContent(String.valueOf(seq)));
		
		return "board/fmbContentPage";
	}
	@RequestMapping(value="/fmbContentPage2", method=RequestMethod.GET)
	public String fmbContentPage2(HttpSession session,HttpServletRequest request,Model model) {
		String seq = request.getParameter("seq");
		boardDao.updateHit(seq); //議고쉶�닔 利앷�
		
		model.addAttribute("fmb", boardDao.getfmbContent(seq));
		model.addAttribute("reply", boardDao.getReplyContent(String.valueOf(seq)));
		
		return "board/fmb_replyList";
	}
	@RequestMapping(value ="/deleteList")
	public String deleteListAction(HttpSession session,HttpServletRequest request) {
	
		String seq = request.getParameter("seq");

		boardDao.deleteList(seq);
		
		return "redirect:fmbList?page=1";
//		return service.deleteListAction(session, request);
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
	
	@RequestMapping(value="/updateList", method=RequestMethod.GET)
	public String updateList(HttpServletRequest request) throws Exception {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		
		boardDao.updateList(seq, title, content);
		
		return "redirect:fmbList?page=1";
		
//		return service.updateList(request);
	}
	@RequestMapping(value = "/showboard", method = RequestMethod.GET)
	public String register(@RequestParam int pages, @RequestParam int lines, Model model) {

		String url = "";
		PageNavigation paging = new PageNavigation(pages, lines);
		
		/////�삤瑜�?
		BoardService service = new BoardService();
		int offset = (paging.getCurrentPageNo() - 1) * paging.getRecordsPerPage();
		List<BoardVO> bookList = service.selectRecordsPerPage(offset, paging.getRecordsPerPage());

		paging.setNumberOfRecords(service.getBoardDao().getNoOfRecords());

		// �럹�씠吏� 留뚮벀
		paging.makePaging();

		// 寃뚯떆�뙋 由ъ뒪�듃媛� 議댁옱�븷 寃쎌슦
		if (bookList != null) {
			model.addAttribute("bookList", bookList);
			model.addAttribute("paging", paging);
			model.addAttribute("servletPath", "BoardCheckOutAdmin");

			url = "show_board_list";//寃뚯떆�뙋 由ъ뒪�듃 蹂댁뿬以� 怨� �씠�룞
		}
		// list媛� 議댁옱�븯吏� �븡�쓣 寃쎌슦
		else {
			model.addAttribute("msg", "Error 媛� 諛쒖깮�뻽�뒿�땲�떎.");

			url = "error_msg";
		}

		return url;
	}

	//댓글
	@RequestMapping(value="/ReplyWrite", method=RequestMethod.GET)
	public String replyWriteAction(HttpSession session,HttpServletRequest request,Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail vo = (UserDetail)auth.getPrincipal();
	      
	    UserVO v1 = vo.getUser();
	    int user_seq = v1.getUser_seq();
		
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
		String comment = request.getParameter("comment");
		System.out.println(comment + " 댓글 ");
		boardDao.writeReply(seq, user_seq, comment);
		
		model.addAttribute("reply", boardDao.getReplyContent(String.valueOf(seq)));
		
		return "redirect:fmbContentPage2?seq=" + seq;
//		return "board/fmb_replyList";
	}
	
	@RequestMapping(value ="/deletereply")
	public String replyDeleteAction(HttpSession session,HttpServletRequest request) {
	
		String seq = request.getParameter("seq");
		String fmb_seq = request.getParameter("fmb_seq");
		boardDao.deleteReply(seq);
		
		return "redirect:fmbContentPage2?seq=" + fmb_seq;
//		return service.replyDeleteAction(session, request);
	}
	
	@RequestMapping(value="/fmbReply", method=RequestMethod.GET)
	public String fmbReply(HttpSession session,HttpServletRequest request,Model model) {
		String seq = request.getParameter("seq");

		model.addAttribute("reply", boardDao.getReplyContent(seq));
		
		return "board/fmbContentPage";
	}

}