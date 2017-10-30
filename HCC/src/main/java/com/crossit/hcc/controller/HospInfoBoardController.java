package com.crossit.hcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crossit.hcc.dao.HospInfoMapperImpl;
import com.crossit.hcc.service.HospInfoBoardService;

@Controller
public class HospInfoBoardController {

	@Autowired
	private HospInfoMapperImpl hospInfoMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	
	// 병원정보공유 글쓰기 페이지
	@RequestMapping(value = "/hospInfoBoard_write", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardWrite(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_write");
		
		return mav;
	}
	
	// 병원정보공유 게시판 
	@RequestMapping(value = "/hospInfoBoard", method = RequestMethod.GET)
	public ModelAndView selectHospInfoBoardList(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_ajax");

		HospInfoBoardService pagingImpl = new HospInfoBoardService(page);
		
		int start = pagingImpl.getStart();
		int end = pagingImpl.getEnd();
		
		//전체 게시물 수
		pagingImpl.setNumberOfRecords(hospInfoMapper.getHospInfoCount());
		//마지막 페이지 번호
				
		pagingImpl.makePaging();
		
		mav.addObject("page", page);	
		mav.addObject("startPage", pagingImpl.getStartPageNo());
		mav.addObject("endPage", pagingImpl.getEndPageNo());
		mav.addObject("list",hospInfoMapper.getHospInfoList(start, end));
		mav.addObject("lastPage", pagingImpl.getFinalPageNo());
		mav.addObject("listt", hospInfoMapper.getHospInfoList(start, end));
		
		System.out.println(start+"//"+end+"//"+page+"//"+pagingImpl.getFinalPageNo());
		return mav;
	}
	
	// 병원정보공유 게시판 상세 페이지 - 유저에 따라 다르게 보여지는 코드 추가해야함 
	@RequestMapping(value = "/hospInfoBoard_detail", method = RequestMethod.POST)
	public ModelAndView toHospInfoBoardDet(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_detail");
		
		mav.addObject("detail", hospInfoMapper.returnDetail(request));			
		mav.addObject("comment", hospInfoMapper.returnComment(request));		
		hospInfoMapper.updateHitCount(request);
		
		return mav;
	}
	
	// 병원정보공유 게시판 수정 페이지로 이동
	@RequestMapping(value = "/hospInfoBoard_modify", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardModify(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_modify");

		mav.addObject("detail", hospInfoMapper.returnDetail(request));
	
		return mav;
	}
	
	// 글 등록
	@RequestMapping(value = "/writeHospInfo", method = RequestMethod.POST) 
	 public ModelAndView writeHospInfo(HttpServletRequest request) throws Exception{ 
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_main");
		
		hospInfoMapper.writeHospInfo(request);
		
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value = "/modifyHospInfo", method = RequestMethod.POST) 
	public ModelAndView modifyHospInfo(HttpServletRequest request) throws Exception{ 
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_main");
		
		hospInfoMapper.modifyHospInfo(request);
		
		return mav;
	}
	
	// 글 삭제
	@RequestMapping(value = "/deleteHospInfo", method = RequestMethod.GET)
	public ModelAndView deleteHospInfo(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_main");
		
		hospInfoMapper.deleteHospInfo(request);
			
		return mav;
	}
	
	// 댓글 등록
	@RequestMapping(value = "/writeHospInfoRepl", method = RequestMethod.POST) 
	public ModelAndView writeHospInfoRepl(HttpServletRequest request) throws Exception{ 
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		hospInfoMapper.writeHospInfoRepl(request);
		
		return mav;
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/deleteHospInfoRepl", method = RequestMethod.GET)
	public ModelAndView deleteHospInfoRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		hospInfoMapper.deleteHospInfoRepl(request);
			
		return mav;
	}

	// 대댓글 등록
	@RequestMapping(value = "/writeHospInfoSubRepl", method = RequestMethod.POST)
	public ModelAndView writeHospInfoSubRepl(HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		hospInfoMapper.writeHospInfoSubRepl(request);
	
		return mav;
	}
	
	// 대댓글 삭제
	@RequestMapping(value = "/deleteHospInfoSubRepl", method = RequestMethod.GET)
	public ModelAndView deleteHospInfoSubRepl(HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
				
		hospInfoMapper.deleteHospInfoSubRepl(request);
			
		return mav;
	}
	
	// 게시글 신고
	@RequestMapping(value = "/reportHospInfo", method = RequestMethod.GET)
	public ModelAndView blameHospInfo(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		hospInfoMapper.blameHospInfo(request);
		hospInfoMapper.updateblameCount(session);
		
		return mav;
	}
	
	// 댓글 신고
	@RequestMapping(value = "/reportHospInfoRepl", method = RequestMethod.GET)
	public ModelAndView reportHospInfoRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
	
		hospInfoMapper.blameHospInfoRepl(request);
		hospInfoMapper.updateblameCount(session);
			
		return mav;
	}
	
	// 대댓글 신고
	@RequestMapping(value = "/reportHospInfoSubRepl", method = RequestMethod.GET)
	public ModelAndView reportHospInfoSubRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
				
		hospInfoMapper.blameHospInfoSubRepl(request);
		hospInfoMapper.updateblameCount(session);
				
		return mav;
	}	
	
	// 게시글 좋아요
	
}
