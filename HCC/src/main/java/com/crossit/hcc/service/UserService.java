package com.crossit.hcc.service;

import com.crossit.hcc.vo.UserVO;

public interface UserService {

	public UserVO getUser(String user_id);//회원 정보 다가져오기.
	public boolean idCheck(String user_id);//아이디 존재 유무만 체크
	public boolean pwCheck(String user_id,String user_pw);//비밀번호 체크
	public void register(UserVO vo);//회원가입
	public void leave(UserVO vo);//회원 탈퇴
	public void infoupdate(UserVO vo);//회원 정보 수정
}
