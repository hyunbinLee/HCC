package com.crossit.hcc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.BoardVO;

@Service
@Configurable
public class BoardMapperImpl implements BoardMapper {

	private SqlSessionTemplate sqlSessionTemplate;
	int noOfRecords=0;
	

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<BoardVO> selectRecordsPerPage(int offset,int noOfRecords) {
		// TODO Auto-generated method stub
		List<BoardVO> boardList = new ArrayList<BoardVO>();
        
        HashMap<String, Object> params = new HashMap<String, Object>();
 
        params.put("offset", offset);
        params.put("noOfRecords", noOfRecords);        
        
        
        
        boardList = sqlSessionTemplate.selectList("com.crossit.hcc.dao.BoardMapper.selectRecordsPerPage", params);
        this.noOfRecords = sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BoardMapper.selectTotalRecords");
            
        
        return boardList;



	}

	@Override
	public int selectTotalRecords() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 public int getNoOfRecords() {
		 
	        return noOfRecords;
	    }



}
