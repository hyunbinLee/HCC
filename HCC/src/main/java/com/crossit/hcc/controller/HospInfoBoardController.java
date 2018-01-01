package com.crossit.hcc.controller;

import java.io.BufferedInputStream;
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
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.crossit.hcc.service.HospInfoBoardService;
import com.crossit.hcc.service.HospInfoBoardServiceImpl;
import com.crossit.hcc.service.PagingService;
import com.crossit.hcc.service.PagingServiceImpl;
import com.crossit.hcc.util.PageNavigation;
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
	
	private PagingService pagingService;
	
	
	
	
	
	//----------------------------------페이지 이동----------------------------------//
	
	// 병원정보공유 게시판리스트 - 페이징처리
	@RequestMapping(value = "/hospInfoBoard", method = RequestMethod.GET)
	public ModelAndView selectHospInfoBoardList(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_ajax");

		if(page != null) {
			mav.addObject("page", page);
		} else {
			mav.addObject("page", "1");
		}
		
		// 페이지당 5개의 글
		pagingService = new PagingServiceImpl(5);
		
		int hospInfoCount = HospInfoBoardService.getHospInfoCount();
		pagingService.paging(page, hospInfoCount);
		
		mav.addObject("startPage", pagingService.startPageNo());
		mav.addObject("endPage", pagingService.endPageNo());
		mav.addObject("list", HospInfoBoardService.selectHospInfoBoardList(pagingService.getStart(), pagingService.getEnd()));
		mav.addObject("lastPage", pagingService.getFinalPageNo());
		
		return mav;
	}	
	
	// 병원정보공유 상세 페이지로 이동 - 유저에 따라 다르게 보여지는 코드 추가해야함 
	@RequestMapping(value = "/hospInfoBoard_detail", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardDet(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_detail");
			
		mav.addObject("detail", HospInfoBoardService.returnDetail(request));			
		mav.addObject("comment", HospInfoBoardService.returnComment(request));		
			
		return mav;
	}
	
	// 병원정보공유 글쓰기 페이지로 이동
	@RequestMapping(value = "/hospInfoBoard_write", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardWrite(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_write");
			
		return mav;
	}
		
	// 병원정보공유 수정 페이지로 이동
	@RequestMapping(value = "/hospInfoBoard_modify", method = RequestMethod.GET)
	public ModelAndView toHospInfoBoardModify(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_modify");

		mav.addObject("detail", HospInfoBoardService.returnDetail(request));
		
		return mav;
	}
	
	//-----------------------------------검색-----------------------------------//
	@RequestMapping(value = "/searchHospInfo", method = RequestMethod.GET)
	public ModelAndView searchHospInfo(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
		ModelAndView mav = new ModelAndView("/board/hospInfoBoard_ajax");
		
		String searchWord = request.getParameter("searchWord");
		searchWord = new String(searchWord.getBytes("8859_1"),"utf-8");
		
		if(page != null) {
			mav.addObject("page", page);
		} else {
			mav.addObject("page", "1");
		}
		
		// 페이지당 5개의 글
		pagingService = new PagingServiceImpl(5);
		
		int hospInfoCount = HospInfoBoardService.getHospInfoCount();
		pagingService.paging(page, hospInfoCount);
		
		mav.addObject("startPage", pagingService.startPageNo());
		mav.addObject("endPage", pagingService.endPageNo());
		mav.addObject("list", HospInfoBoardService.searchHospInfo(pagingService.getStart(), pagingService.getEnd(), request));
		mav.addObject("lastPage", pagingService.getFinalPageNo());
		mav.addObject("searchType", request.getParameter("searchType"));
		mav.addObject("searchCase", request.getParameter("searchCase"));
		mav.addObject("searchWord", searchWord);
		
		return mav;
		
	}
	
	
	
	
	
	//----------------------------------API TEST----------------------------------//
	/*
		@RequestMapping(value = "/toApiTest", method = RequestMethod.GET)
		public ModelAndView toApiTest(HttpServletRequest request, @RequestParam(value="page", required=false) String page) throws Exception{
			ModelAndView mav = new ModelAndView("/board/apiTest");
			
			String title = request.getParameter("title");
			title = new String(title.getBytes("8859_1"),"utf-8");
			String content = request.getParameter("content");
			content = new String(content.getBytes("8859_1"),"utf-8");
			
			int numOfRows = 10; // 한 페이지의 레코드 수
			int startPage, endPage;
			int count = 0;
			
			if(page != null) {
				mav.addObject("page", page);
			} else {
				mav.addObject("page", "1");
			}
			
			String newZipcodeUrl = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList";
			String serviceKey = "NrK5GPwGddQbJdK1iHrfmju2qMbDYuYfgy7bmM6ZRB6BZKNJ3cuZgfKx1GUeogmIGkDhN%2FSe9sxo0AmyAr1CIw%3D%3D";
			
			String apiUrl = newZipcodeUrl + "?serviceKey=" + serviceKey + "&pageNo=" + 1 + "&numOfRows=" + 10;
			
			try {
				URL url = new URL(apiUrl);
				
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				BufferedInputStream bis = new BufferedInputStream(url.openStream());
				xpp.setInput(bis, "utf-8");
				
				String tag = null;
				int event_type = xpp.getEventType();
				
				ArrayList<String> list = new ArrayList<String>();
				String yadmNm = null;				
				
				while(event_type != XmlPullParser.END_DOCUMENT) {
						if(event_type == XmlPullParser.START_TAG) {
							tag = xpp.getName();
							System.out.print(tag+"//");
							count++;
						} else if(event_type == XmlPullParser.TEXT) {
							System.out.print(xpp.getText()+"//");
							if(tag.equals("yadmNm")) {
								yadmNm = xpp.getText();
							}
						} else if(event_type == XmlPullParser.END_TAG) {
							tag = xpp.getName();
							System.out.print(tag+"//");
							if(tag.equals("item")) {
								list.add(yadmNm);
							}
						}
						event_type = xpp.next();
					}
				mav.addObject("list", list);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("star", request.getParameter("star"));
			mav.addObject("type", request.getParameter("type"));
			mav.addObject("title", title);
			mav.addObject("content", content);
			
			return mav;
		}
		*/
		@RequestMapping(value = "/apiTest", method = RequestMethod.GET)
		public ModelAndView apiTest(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="page", required=false) String page) throws Exception{
			response.setCharacterEncoding("UTF-8");
			
			ModelAndView mav = new ModelAndView("/board/apiTest");
			
			String encodedHospNm = null;
			if(request.getParameter("hospNm") != null) {
				String hospNm = request.getParameter("hospNm");
				hospNm = new String(hospNm.getBytes("8859_1"),"utf-8");
				encodedHospNm = URLEncoder.encode(hospNm, "UTF-8");
				mav.addObject("hospNm", hospNm);
			}
			
			String title = request.getParameter("title");
			if(title != null) title = new String(title.getBytes("8859_1"),"utf-8");
			String content = request.getParameter("content");
			if(content != null) content = new String(content.getBytes("8859_1"),"utf-8");
			
			int numOfRows = 10; // 한 페이지의 레코드 수
			int startPage, endPage;
			int totalCount = 0;
			
			if(page != null) {
				mav.addObject("page", page);
			} else {
				mav.addObject("page", "1");
			}
			
			String newZipcodeUrl = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList";
			String serviceKey = "NrK5GPwGddQbJdK1iHrfmju2qMbDYuYfgy7bmM6ZRB6BZKNJ3cuZgfKx1GUeogmIGkDhN%2FSe9sxo0AmyAr1CIw%3D%3D";
			
			String apiUrl;
			if(request.getParameter("hospNm") != null) {
				apiUrl = newZipcodeUrl + "?serviceKey=" + serviceKey + "&pageNo=" + page + "&numOfRows=" + 10 +"&yadmNm=" + encodedHospNm;
			} else {
				apiUrl = newZipcodeUrl + "?serviceKey=" + serviceKey + "&pageNo=" + page + "&numOfRows=" + 10;
			}
						
			try {
				URL url = new URL(apiUrl);
				
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				BufferedInputStream bis = new BufferedInputStream(url.openStream());
				xpp.setInput(bis, "utf-8");
				
				String tag = null;
				int event_type = xpp.getEventType();
				
				ArrayList<String> list = new ArrayList<String>();
				String yadmNm = null;
				
				while(event_type != XmlPullParser.END_DOCUMENT) {
					if(event_type == XmlPullParser.START_TAG) {
						tag = xpp.getName();
					} else if(event_type == XmlPullParser.TEXT) {
						if(tag.equals("yadmNm")) {
							yadmNm = xpp.getText();
						} else if(tag.equals("totalCount")) {
							totalCount = Integer.parseInt(xpp.getText());
						}
					} else if(event_type == XmlPullParser.END_TAG) {
						tag = xpp.getName();
						if(tag.equals("item")) {
							list.add(yadmNm);
						}
					}
					event_type = xpp.next();
				}
				
				// 페이지당 5개의 글
				pagingService = new PagingServiceImpl(10);
				pagingService.paging(page, totalCount);
				
				System.out.println("//"+totalCount+"//");
				
				mav.addObject("startPage", pagingService.startPageNo());
				mav.addObject("endPage", pagingService.endPageNo());
				mav.addObject("lastPage", pagingService.getFinalPageNo());
				mav.addObject("list", list);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("star", request.getParameter("star"));
			mav.addObject("type", request.getParameter("type"));
			mav.addObject("title", title);
			mav.addObject("content", content);
			
			
			return mav;
		}
		
		@RequestMapping(value = "/returnToWritePage", method = RequestMethod.GET)
		public ModelAndView returnToWritePage(HttpServletRequest request) throws Exception{
			ModelAndView mav = new ModelAndView("/board/hospInfoBoard_write");
			
			String title = request.getParameter("title");
			if(title != null) title = new String(title.getBytes("8859_1"),"utf-8");
			String content = request.getParameter("content");
			if(title != null) content = new String(content.getBytes("8859_1"),"utf-8");
			String hospNm = request.getParameter("hospNm");
			hospNm = new String(content.getBytes("8859_1"),"utf-8");
			
			mav.addObject("star", request.getParameter("star"));
			mav.addObject("type", request.getParameter("type"));
			mav.addObject("title", title);
			mav.addObject("content", content);
			mav.addObject("hospNm", hospNm);
			
			return mav;
		}
	
		
	//----------------------------------게시글 CRUD----------------------------------//
	
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
	
	
	
	
	//----------------------------------댓글 CRUD----------------------------------//
	
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
	
	
	
	
	//----------------------------------기타 기능----------------------------------//
	
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