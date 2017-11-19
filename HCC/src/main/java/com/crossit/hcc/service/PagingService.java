package com.crossit.hcc.service;

public interface PagingService {
	//페이징
	public void paging(String page,int noticeCount);
	//시작 넘버
	public int getStart();
	//끝넘버
	public int getEnd();
	public int startPageNo();
	public int endPageNo();
	public int getFinalPageNo();
	
}
