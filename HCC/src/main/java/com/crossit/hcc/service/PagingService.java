package com.crossit.hcc.service;

import java.util.List;

import com.crossit.hcc.util.PageNavigation;
import com.crossit.hcc.vo.HCCFmbVO;


public class PagingService{
	private PageNavigation pageNav;
	
	private int currentPageNo;
	private int recordsPerPage;
	
	private int start;
	private int end;
	

	public PagingService(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
		//페이지당 글수 생성자에서 관리
	}
	
	public void paging(String page,int noticeCount) {
		try {
			currentPageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			currentPageNo = 1;
		}
		
		
		pageNav = new PageNavigation(currentPageNo, recordsPerPage);
		
		//호출할 페이지 레코드 번호
		start = (currentPageNo -1)* pageNav.getRecordsPerPage() +1;
		end = currentPageNo * pageNav.getRecordsPerPage();
		
		
		pageNav.setNumberOfRecords(noticeCount);
		
		pageNav.makePaging();
	}
	
	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int startPageNo() {
		return pageNav.getStartPageNo();
	}
	
	public int endPageNo() {
		return pageNav.getEndPageNo();
	}
	
	public List<HCCFmbVO> getList(){
		return null;
	}
	
	public int getFinalPageNo() {
		return pageNav.getFinalPageNo();
	}
	
}
