package com.crossit.hcc.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SelfDiagnoMapperImpl implements SelfDiagnoMapper{

	private SqlSessionTemplate sqlSessionTemplate;


	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insertSelfDiagno(Map<String, Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.SelfDiagnoImpl.insertSelfDiagno", map);
	}
}
