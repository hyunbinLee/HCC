package com.crossit.hcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crossit.hcc.service.SelfDiagnoServiceImpl;

@Controller
public class SelfDiagnoController {

	@Autowired
	private SelfDiagnoServiceImpl SelfDiagnoService;
	
	@Autowired
	SqlSession sqlSession;
	
	// 자가진단 메인으로 이동
	@RequestMapping(value = "/selfDiagno", method = RequestMethod.GET)
	public ModelAndView selfDiagno(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno/selfDiagno");
			
		return mav;
	}
	
	// 요통 페이지로 이동
	@RequestMapping(value = "/selfDiagno_backache", method = RequestMethod.GET)
	public ModelAndView selfDiagno_backache(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno/selfDiagno_backache");
				
		return mav;
	}	
	
	// 요통 데이터 입력
	@RequestMapping(value = "/insertSelfDiagno_backache", method = RequestMethod.GET)
	public ModelAndView insertSelfDiagno_backache(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno/selfDiagno");
				
		SelfDiagnoService.insertSelfDiagno_backache(session, request);
		
		return mav;
	}		
	
	
	// 급성복통 페이지로 이동
	@RequestMapping(value = "/selfDiagno_acutestomachache", method = RequestMethod.GET)
	public ModelAndView selfDiagno_acutestomachache(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno/selfDiagno_acutestomachache");
					
		return mav;
	}		
	
	// 급성복통 데이터 입력
	@RequestMapping(value = "/insertSelfDiagno_acutestomachache", method = RequestMethod.GET)
	public ModelAndView insertSelfDiagno_acutestomachache(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno/selfDiagno");
				
		SelfDiagnoService.insertSelfDiagno_acutestomachache(session, request);
		
		return mav;
	}		
}
