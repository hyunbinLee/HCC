package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.HCCFmbVO;

public interface NoticeMapper {
	public List<HCCFmbVO> getNoticeList(int start,int end);
	public int getNoticeCount();
	
	public void writeNotice(String title,String content);
	public HCCFmbVO getNoticeContent(String seq);
	public void deleteNotice(String seq);
	public void updateNotice(String seq,String title,String content);
	
	public void updateHit(String seq);
}
