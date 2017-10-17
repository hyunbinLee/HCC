package com.crossit.hcc.dao;

import com.crossit.hcc.vo.UserVO;

public interface UserMapper {

	public UserVO selectUserByID(String user_id);//회원 정보 다가져오기.
	public boolean compareUserByID(String user_id);//아이디 존재 유무만 체크
	public void insertUserVO(UserVO vo);//회원가입
	public void deleteUserByID(String user_id);//회원탈퇴
	public void updateUserByVO(UserVO vo);//회원 정보 수정
}
