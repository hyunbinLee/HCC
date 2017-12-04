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
	
	public void insertBlameList(String blame_code,String blame_gubun,char blame_type,String blame_content,String blame_reg_seq) {
		HashMap<String , Object> params = new HashMap<String, Object>();
		params.put("param1", blame_code);
		params.put("param2", blame_gubun);
		params.put("param3", blame_type);
		params.put("param4", blame_content);
		params.put("param5", blame_reg_seq);
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.BlameMapper.insertBlameList", params);
	}
	
	public void deleteBlameList(String blame_seq) {
		
		sqlSessionTemplate.delete("com.crossit.hcc.dao.BlameMapper.deleteBlameList",blame_seq);
	}
	
	public void upBlameFmb(String blame_seq) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.BlameMapper.upBlameFmb",blame_seq);
	}
	
}
