package com.crossit.hcc.service;

import com.crossit.hcc.dao.UserMapperImpl;
import com.crossit.hcc.vo.UserVO;

public class UserServiceImpl implements UserService {

	private UserMapperImpl userMapper;

	public void setUserMapper(UserMapperImpl userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserVO getUser(String user_id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByID(user_id);
	}

	@Override
	public boolean idCheck(String user_id) {
		// TODO Auto-generated method stub
		return userMapper.compareUserByID(user_id);
	}

	@Override
	public void register(UserVO vo) {
		// TODO Auto-generated method stub
		userMapper.insertUserVO(vo);
	}

	@Override
	public void leave(UserVO vo) {//아이디 삭제
		// TODO Auto-generated method stub
		UserVO gotten_vo = userMapper.selectUserByID(vo.getUser_id());
		if (gotten_vo == null) {
			System.out.println("아이디 틀렸슴.");
		} 
		else 
		{
			if(gotten_vo.getUser_pw().equals(vo.getUser_pw()))
			{
				System.out.println("비밀번호 틀렸슴.");
			}
			else{
				userMapper.deleteUserByID(gotten_vo.getUser_id());
			}
		}
	}

	@Override
	public void infoupdate(UserVO vo) {//회원정보 변경.
		// TODO Auto-generated method stub
		userMapper.updateUserByVO(vo);
		
	}

}
