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
	
	// 자가진단 체크페이지
	@RequestMapping(value = "/selfDiagno_detail", method = RequestMethod.GET)
	public ModelAndView selfDiagno_detail(HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno_detail");
			
		return mav;
	}
	
	// 자가진단 데이터 입력
	@RequestMapping(value = "/insertSelfDiagno", method = RequestMethod.GET)
	public ModelAndView insertSelfDigano(HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView("/board/selfDiagno_detail");
		
		SelfDiagnoService.insertSelfDiagno(session, request);
		
		return mav;
	}
}
