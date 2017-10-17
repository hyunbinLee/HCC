package com.crossit.hcc.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.crossit.hcc.vo.UserVO;

public class UserLoad implements UserDetailsService {


	private UserServiceImpl userDao;
	
	public void setUserDao(UserServiceImpl userDao ) {
		this.userDao = userDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO uv = null;
		try {
			uv = userDao.getUser(username);

			if (uv == null) {	
				throw new BadCredentialsException("ID나 비밀번호가 잘못 됬습니다.");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("ERROR") {

				private static final long serialVersionUID = 1L;
			};

		}
		;
		return new UserDetail(uv);
	}

}
