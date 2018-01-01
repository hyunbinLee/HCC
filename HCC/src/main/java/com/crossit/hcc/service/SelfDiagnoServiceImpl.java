package com.crossit.hcc.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.crossit.hcc.dao.SelfDiagnoMapper;

@Service("SelfDiagnoService")
public class SelfDiagnoServiceImpl implements SelfDiagnoService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private SelfDiagnoMapper SelfDiagnoMapper;
	
	public void insertSelfDiagno_backache(HttpSession session, HttpServletRequest request) {
		
		String q1, q2, q3, q4;
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		String user_seq = "" + userdetail.getUser().getUser_seq();
		map.put("user_seq", user_seq);
		
		if(request.getParameter("q1") == null) {
			q1 = "-";
		} else {
			q1 = request.getParameter("q1");
		}
		
		if(request.getParameter("q2") == null) {
			q2 = "-";
		} else {
			q2 = request.getParameter("q2");
		}
		
		if(request.getParameter("q3") == null) {
			q3 = "-";
		} else {
			q3 = request.getParameter("q3");
		}
		if(request.getParameter("q4") == null) {
			q4 = "-";
		} else {
			q4 = request.getParameter("q4");
		}		
		
		String casee = "A";
		map.put("case", casee);
		map.put("q1", q1);
		map.put("q2", q2);
		map.put("q3", q3);
		map.put("q4", q4);
		map.put("result", request.getParameter("result"));
		
		SelfDiagnoMapper.insertSelfDiagno_backache(map);
	}

	
	public void insertSelfDiagno_acutestomachache(HttpSession session, HttpServletRequest request) {
		String q1, q2, q3, q4, q5, q6, q7;
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail userdetail = (UserDetail)auth.getPrincipal();
		String user_seq = "" + userdetail.getUser().getUser_seq();
		map.put("user_seq", user_seq);
		
		if(request.getParameter("q1") == null) {
			q1 = "-";
		} else {
			q1 = request.getParameter("q1");
		}
		
		if(request.getParameter("q2") == null) {
			q2 = "-";
		} else {
			q2 = request.getParameter("q2");
		}
		
		if(request.getParameter("q3") == null) {
			q3 = "-";
		} else {
			q3 = request.getParameter("q3");
		}
		
		if(request.getParameter("q4") == null) {
			q4 = "-";
		} else {
			q4 = request.getParameter("q4");
		}		
		
		if(request.getParameter("q5") == null) {
			q5 = "-";
		} else {
			q5 = request.getParameter("q5");
		}	
		
		if(request.getParameter("q6") == null) {
			q6 = "-";
		} else {
			q6 = request.getParameter("q6");
		}	
		
		if(request.getParameter("q7") == null) {
			q7 = "-";
		} else {
			q7 = request.getParameter("q7");
		}	
		
		String casee = "B";
		map.put("case", casee);
		map.put("q1", q1);
		map.put("q2", q2);
		map.put("q3", q3);
		map.put("q4", q4);
		map.put("q5", q5);
		map.put("q6", q6);
		map.put("q7", q7);
		map.put("result", request.getParameter("result"));
		
		SelfDiagnoMapper.insertSelfDiagno_acutestomachache(map);
	}

}
