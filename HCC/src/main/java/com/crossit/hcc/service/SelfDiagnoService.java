package com.crossit.hcc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SelfDiagnoService {


	public void insertSelfDiagno_backache(HttpSession session, HttpServletRequest request);
	
	public void insertSelfDiagno_acutestomachache(HttpSession session, HttpServletRequest request);
}
