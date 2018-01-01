package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HCCFmbVO;

public interface BoardMapper {
	public List<BoardVO> selectRecordsPerPage(int offset, int noOfRecords);
	public int selectTotalRecords();
	
	public HCCFmbVO getfmbContent(String seq);
	public void writefmb(String title,String content,int user_seq, String type, String status);
	public int getfmbCount();
	public int deleteList(String seq);
	public List<HCCFmbVO> getfmbList(int start,int end);
	public void updateList(int seq,String title,String content);
	public int updateHit(String seq);
	public int likeList(String seq);
	public int unlikeList(String seq);
}
