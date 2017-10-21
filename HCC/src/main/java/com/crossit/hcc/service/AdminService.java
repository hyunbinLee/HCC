package com.crossit.hcc.service;

import com.crossit.hcc.util.PageNavigation;

public class AdminService {

	private int currentPageNo;
	private int recordsPerPage;
	private int start;
	private int end;
	
	PageNavigation paging;
	public AdminService(String page) {
		try {
			currentPageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			currentPageNo = 1;
		}
		
		recordsPerPage = 20; //한 페이지당 20명의 회원
		
		start = (currentPageNo -1) * recordsPerPage +1;
		end = currentPageNo * recordsPerPage;
		
		paging = new PageNavigation(currentPageNo, recordsPerPage);
	}
	
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public void setNumberOfRecords(int numberOfRecords) {
		paging.setNumberOfRecords(numberOfRecords);
	}
	public void makePage() {
		paging.makePaging();
	}
	public int getFinalPageNo() {
		return paging.getFinalPageNo();
	}
	
	public int getStartPage() {
		return paging.getStartPageNo();
	}
	public int getEndPage() {
		return paging.getEndPageNo();
	}
}
