package com.crossit.hcc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.UserVO;

@Service
@Configurable
public class UserMapperImpl implements UserMapper{
	
	private SqlSessionTemplate sqlSessionTemplate;


	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public UserVO selectUserByID(String user_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.UserMapper.selectUserByID",user_id);
	}


	@Override
	public boolean compareUserByID(String user_id) {
		// TODO Auto-generated method stub
		if(sqlSessionTemplate.selectOne("com.crossit.hcc.dao.UserMapper.compareUserByID",user_id)!=null)
			return true;
		else
			return false;	
		}


	@Override
	public void insertUserVO(UserVO vo) {//vo로 회원 정보 등록
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("com.crossit.hcc.dao.UserMapper.insertUserVO", vo);

	}


	@Override
	public void deleteUserByID(String user_id) {//id로 아이디 삭제하기
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("com.crossit.hcc.dao.UserMapper.deleteUserByVO", user_id);
	}


	@Override
	public void updateUserByVO(UserVO vo) {//vo로 업데이트하기
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("com.crossit.hcc.dao.UserMapper.updateUserByVO",vo);
	}
	
	

}
