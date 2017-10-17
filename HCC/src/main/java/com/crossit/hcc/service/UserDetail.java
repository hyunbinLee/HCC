package com.crossit.hcc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.crossit.hcc.vo.UserVO;

public class UserDetail implements UserDetails {

	private List<GrantedAuthority> authority;

	private UserVO uv;

	public UserDetail(UserVO uv) {

		this.uv = uv;
		authority = new ArrayList<GrantedAuthority>();
		String[] roles = uv.getUser_kind().split(",");

		for (String role : roles) {

			if (role.equals("U") || role.equals("D"))
				authority.add(new SimpleGrantedAuthority("ROLE_USER"));
			else if (role.equals("A"))
				authority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			else
				continue;
		}
	}

	public UserVO getUser() {
		return this.uv;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return uv.getUser_pw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uv.getUser_id();
	}

	public String getRealusername(){
		return uv.getUser_name();
	}//세션에 필요한 것들은 여기서 갖고오면 됨.
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
