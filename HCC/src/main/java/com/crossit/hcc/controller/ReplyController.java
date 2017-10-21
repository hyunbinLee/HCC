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

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.dao.NoticeMapperImple;
import com.crossit.hcc.service.BoardService;
import com.crossit.hcc.service.NoticeService;
import com.crossit.hcc.util.PageNavigation;
import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HCCFmb_replyVO;;

@Controller
public class ReplyController {

	/*
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value = "/insertReply", method = RequestMethod.GET)
    public void insert(HCCFmb_replyVO vo, HttpSession session){
        String user_id = (String) session.getAttribute("user_id");
        vo.setFmb_seq(user_id);
        replyService.create(vo);
    }
	
	@RequestMapping(value = "/replyList", method=RequestMethod.GET)
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
*/
}
