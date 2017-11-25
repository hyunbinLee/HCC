package com.crossit.hcc.controller;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.crossit.hcc.service.HospInfoBoardService;
import com.crossit.hcc.service.HospInfoBoardServiceImpl;
import com.crossit.hcc.vo.HospInfoBoardVO;
import com.crossit.hcc.vo.HospInfoListVO;
import com.crossit.hcc.vo.HospInfoVO;

@Controller
public class HospInfoBoardController {

	@Autowired
	private HospInfoBoardServiceImpl HospInfoBoardService;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	// 병원정보공유 글쓰기 페이지
	@RequestMapping(value = "/hospInfoBoard_write", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardWrite(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_write");
		
		return mav;
	}
	/*
	// 병원정보공유 게시판 
	@RequestMapping(value = "/hospInfoBoard", method = RequestMethod.GET)
	public ModelAndView selectHospInfoBoardList(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_ajax");

		mav.addObject("list", HospInfoBoardService.hospInfoList(request, page));
		
		return mav;
	}
	*/
	// 병원정보공유 게시판 
		@RequestMapping(value = "/hospInfoBoard", method = RequestMethod.GET)
		public ModelAndView selectHospInfoBoardList(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
			ModelAndView mav = new ModelAndView("/board/hospInfoBoard");

			mav.addObject("list", HospInfoBoardService.selectHospInfoBoardList(request));
			
			return mav;
		}
	
	
	// 병원정보공유 게시판 상세 페이지 - 유저에 따라 다르게 보여지는 코드 추가해야함 
	@RequestMapping(value = "/hospInfoBoard_detail", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardDet(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_detail");
		
		mav.addObject("detail", HospInfoBoardService.returnDetail(request));			
		mav.addObject("comment", HospInfoBoardService.returnComment(request));		
		
		return mav;
	}
	
	// 병원정보공유 게시판 수정 페이지로 이동
	@RequestMapping(value = "/hospInfoBoard_modify", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardModify(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_modify");

		mav.addObject("detail", HospInfoBoardService.returnDetail(request));
	
		return mav;
	}
	
	// 글 등록
	@RequestMapping(value = "/writeHospInfo", method = RequestMethod.GET) 
	 public ModelAndView writeHospInfo(HttpSession session, HttpServletRequest request) throws Exception{ 
		/*
		// xml 데이터를 response 받을 API 주소
		String uri = "API 주소";
		
		// RestTemplate 생성
		RestTemplate restTemplate = new RestTemplate();
		
		// 오브젝트로 결과값 받아오기
		HospInfoListVO hospInfoList = restTemplate.getForObject(uri, HospInfoListVO.class);
		
		// 회원 정보 리스트
		List<HospInfoVO> result = hospInfoList.getHospInfo();
		
		// model addAttribute("result", result);
		//return "memberList";
	*/
		ModelAndView mav = new ModelAndView("redirect:/hospInfoBoard");
		
		HospInfoBoardService.writeHospInfo(request, session);
		
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value = "/modifyHospInfo", method = RequestMethod.GET) 
	public ModelAndView modifyHospInfo(HttpServletRequest request) throws Exception{ 
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		
		ModelAndView mav = new ModelAndView("redirect:/hospInfoBoard_detail?boardseq="+boardseq+"");
		
		HospInfoBoardService.modifyHospInfo(request);
		
		return mav;
	}
	
	// 글 삭제
	@RequestMapping(value = "/deleteHospInfo", method = RequestMethod.GET)
	public ModelAndView deleteHospInfo(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:/hospInfoBoard");
		
		HospInfoBoardService.deleteHospInfo(request);
		
		return mav;
	}
	
	// 댓글 등록
	@RequestMapping(value = "/writeHospInfoRepl", method = RequestMethod.POST) 
	public ModelAndView writeHospInfoRepl(HttpServletRequest request) throws Exception{ 
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		HospInfoBoardService.writeHospInfoRepl(request);
		
		return mav;
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/deleteHospInfoRepl", method = RequestMethod.GET)
	public ModelAndView deleteHospInfoRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		HospInfoBoardService.deleteHospInfoRepl(request);
			
		return mav;
	}

	// 대댓글 등록
	@RequestMapping(value = "/writeHospInfoSubRepl", method = RequestMethod.POST)
	public ModelAndView writeHospInfoSubRepl(HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		HospInfoBoardService.writeHospInfoSubRepl(request);
	
		return mav;
	}
	
	// 대댓글 삭제
	@RequestMapping(value = "/deleteHospInfoSubRepl", method = RequestMethod.GET)
	public ModelAndView deleteHospInfoSubRepl(HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
				
		HospInfoBoardService.deleteHospInfoSubRepl(request);
			
		return mav;
	}
	
	// 게시글 신고
	@RequestMapping(value = "/reportHospInfo", method = RequestMethod.GET)
	public ModelAndView blameHospInfo(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
		
		HospInfoBoardService.blameHospInfo(request);
		HospInfoBoardService.updateblameCount(session);
		
		return mav;
	}
	
	// 댓글 신고
	@RequestMapping(value = "/reportHospInfoRepl", method = RequestMethod.GET)
	public ModelAndView reportHospInfoRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
	
		HospInfoBoardService.blameHospInfoRepl(request);
		HospInfoBoardService.updateblameCount(session);

			
		return mav;
	}
	
	// 대댓글 신고
	@RequestMapping(value = "/reportHospInfoSubRepl", method = RequestMethod.GET)
	public ModelAndView reportHospInfoSubRepl(HttpSession session, HttpServletRequest request) throws Exception{
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		ModelAndView mav = new ModelAndView("redirect:/board/hospInfoBoard_det?boardseq="+boardseq+"");	
				
		HospInfoBoardService.blameHospInfoSubRepl(request);
		HospInfoBoardService.updateblameCount(session);

				
		return mav;
	}	
	
	// 게시글 좋아요
	
}