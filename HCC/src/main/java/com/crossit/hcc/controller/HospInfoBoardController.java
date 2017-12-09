package com.crossit.hcc.controller;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.stream.StreamSource;

import org.apache.ibatis.session.SqlSession;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.omg.CORBA_2_3.portable.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import com.crossit.hcc.vo.ItemList;
import com.crossit.hcc.vo.School;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
		@RequestMapping(value = "/toApiTest", method = RequestMethod.GET)
		public ModelAndView toApiTest(HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView("/board/apiTest");
			
			return mav;
		}
		
		@RequestMapping(value = "/apiTest", method = RequestMethod.GET)
		public ModelAndView apiTest(HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView("/board/apiTestResult");
			
			String hospNm = request.getParameter("hospNm");
			
			String rvalUrl = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?serviceKey=FHx3MZ5wfeyTMxpRxvpPc2EcmTn4Ypw%2BNGg8QXPHk0wbqRe47DQhFDrsM8ZzPDxpywj3IavwroLPuyPBK2Mvsg%3D%3D&yadmNm="+hospNm+"";
			
			URL url = new URL(rvalUrl);
			URLConnection conn = url.openConnection(); // URL 연결
			conn.setRequestProperty("accept-language", "ko"); // 언어설정
			
			// XML 자료 가져오기
			SAXBuilder builder = new SAXBuilder(); 
			Document doc = builder.build(conn.getInputStream());
			
			// itemlist 하위에 우편번호와 주소값을 가지고 있다.
			Element itemlist = doc.getRootElement().getChild("itemlist");
			List list = itemlist.getChildren();
			
			mav.addObject("list", list);


			/*
			try{
				SAXBuilder parser = new SAXBuilder(); // 문서의 빌드화
				parser.setIgnoringElementContentWhitespace(true);
				Document doc = parser.build(rvalUrl); // xml파일을 부른다.
				Element root = doc.getRootElement(); // xml파일의 첫번째 태그를 부른다.
				List newAddressList = root.getChildren("newAddressList"); // 루트의 하위 요소를 구함.
				List cmmMsgHeader = root.getChildren("cmmMsgHeader");
				if(newAddressList.size() == 0)
				{
					mav.addObject(cmmMsgHeader.get(0));
				}
				else
				{
					mav.addObject(cmmMsgHeader.get(0));
					for(int i=0; i<newAddressList.size(); i++)
						mav.addObject(newAddressList.get(i));
				}
			} catch(Exception e) {
				System.out.println("apiTest 실패");
			}
			*/
			
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