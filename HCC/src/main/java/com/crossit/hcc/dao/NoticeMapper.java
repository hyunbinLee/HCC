package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.LikeVO;
import com.crossit.hcc.vo.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> getNoticeList(int start,int end);
	public int getNoticeCount();
	
	public void writeNotice(String title,String content, int regSeq);
	public NoticeVO getNoticeContent(String seq);
	public void deleteNotice(String seq);
	public void updateNotice(String seq,String title,String content);
	
	public void updateHit(String seq);
	
	public LikeVO checkLike(String like_seq,String like_code,String like_reg_seq);
	
	public void addLikeList(String like_seq,String like_code,String like_reg_seq);
	public void updateNoticeLike(String like_seq);
	
	
}
