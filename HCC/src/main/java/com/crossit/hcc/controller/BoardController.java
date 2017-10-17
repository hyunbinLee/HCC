package com.crossit.hcc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.service.BoardService;
import com.crossit.hcc.util.PageNavigation;;

@Controller
public class BoardController {

	@RequestMapping(value = "/showboard", method = RequestMethod.GET)
	public String register(@RequestParam int pages, @RequestParam int lines, Model model) {

		String url = "";
		PageNavigation paging = new PageNavigation(pages, lines);
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
