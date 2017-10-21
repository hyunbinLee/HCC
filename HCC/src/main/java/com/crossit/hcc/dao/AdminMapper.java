package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.UserVO;

public interface AdminMapper {
	public List<UserVO> getUserList(int start,int end,String kind);
	public int getUserCount(String kind);
}
