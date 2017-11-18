package com.crossit.hcc.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.crossit.hcc.vo.BlameVO;

public class BlameMapper {
	

	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<BlameVO> getBlameList(int start,int end){
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("param1", start);
		params.put("param2", end);
		
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.BlameMapper.getBlameList", params);
	}
	
	public int getBlameCount() {
		
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BlameMapper.getBlameCount");
	}
}
