package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.HCCFmb_replyVO;

public interface ReplyMapper {
	public List<HCCFmb_replyVO> getfmbList(int start,int end);
	public void create(HCCFmb_replyVO vo);
	public void update(HCCFmb_replyVO vo);
	public void delete(String seq);
	public int getreplyCount();
}
