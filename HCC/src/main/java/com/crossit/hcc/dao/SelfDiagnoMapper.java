package com.crossit.hcc.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SelfDiagnoMapper {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertSelfDiagno_backache(Map<String, Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.SelfDiagnoMapper.insertSelfDiagno_backache", map);
		sqlSessionTemplate.insert("com.crossit.hcc.dao.SelfDiagnoMapper.insertSelfDiagno_total", map);
	}

	public void insertSelfDiagno_acutestomachache(Map<String, Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.SelfDiagnoMapper.insertSelfDiagno_acutestomachache", map);
		sqlSessionTemplate.insert("com.crossit.hcc.dao.SelfDiagnoMapper.insertSelfDiagno_total", map);
	}
	
	
}
