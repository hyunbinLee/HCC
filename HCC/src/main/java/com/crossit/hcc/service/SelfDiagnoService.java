package com.crossit.hcc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SelfDiagnoService {


	public void insertSelfDiagno(HttpSession session, HttpServletRequest request);
}
