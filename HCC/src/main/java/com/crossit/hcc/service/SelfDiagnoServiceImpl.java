package com.crossit.hcc.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.hcc.dao.HospInfoMapperImpl;
import com.crossit.hcc.dao.SelfDiagnoMapperImpl;

@Service("SelfDiagnoServiceImpl")
public class SelfDiagnoServiceImpl implements SelfDiagnoService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private SelfDiagnoMapperImpl SelfDiagnoMapper;
	
	public void insertSelfDiagno(HttpSession session, HttpServletRequest request) {
		
		String q1, q2, q3, q4, q5, q6, q7, q8, q9, q10;
		int checkA = 0, checkB = 0;
		String resultCase;
		
		q1 = request.getParameter("q1").toString();
		q2 = request.getParameter("q2").toString();
		q3 = request.getParameter("q3").toString();
		q4 = request.getParameter("q4").toString();
		q5 = request.getParameter("q5").toString();
		q6 = request.getParameter("q6").toString();
		q7 = request.getParameter("q7").toString();
		q8 = request.getParameter("q8").toString();
		q9 = request.getParameter("q9").toString();
		q10 = request.getParameter("q10").toString();
		
		if(q1.equals("X")) checkA++; if(q2.equals("X")) checkA++;
		if(q3.equals("X")) checkA++; if(q4.equals("X")) checkA++;
		if(q5.equals("X")) checkA++;
		if(q6.equals("O")) checkB++; if(q7.equals("O")) checkB++;
		if(q8.equals("O")) checkB++; if(q9.equals("O")) checkB++;
		if(q10.equals("O")) checkB++;
		
		if(checkA >= 3 && checkB >= 3) resultCase = "A";
		else if(checkA < 3 && checkB >= 3) resultCase = "B";
		else if(checkA >= 3 && checkB < 3) resultCase = "C";
		else resultCase = "D";
		
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("userseq", Integer.parseInt(session.getAttribute("userseq").toString()));
		map.put("q1", q1); map.put("q2", q2); 
		map.put("q3", q3); map.put("q4", q4); 
		map.put("q5", q5); map.put("q6", q6); 
		map.put("q7", q7); map.put("q8", q8); 
		map.put("q9", q9); map.put("q10", q10); 
		map.put("resultCase", resultCase);		
		
		
		SelfDiagnoMapper.insertSelfDiagno(map);
		
	}

}
