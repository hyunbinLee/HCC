package com.crossit.hcc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HCCFmbVO;

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
	@Override
	public int getfmbCount() {
		// TODO Auto-generated method stub
			return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BoardMapper.getfmbCount");
	}
	@Override
	public void writefmb(String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", title);
		params.put("param2", content);
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.BoardMapper.writefmb",params);
	}
	@Override
	public void deleteList(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("com.crossit.hcc.dao.BoardMapper.getfmbContent", seq);
		
	}

	@Override
	public List<HCCFmbVO> getfmbList(int start, int end) {
		// TODO Auto-generated method stub	
		HashMap<String,String> params = new HashMap<String, String>();
		params.put("param1", String.valueOf(start));
		params.put("param2", String.valueOf(end));

		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.BoardMapper.getfmbList", params);
	}
	@Override
	public HCCFmbVO getfmbContent(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BoardMapper.getfmbContent", seq);
	}
	@Override
	public void updateList(String seq, String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", seq);
		params.put("param2", title);
		params.put("param3", content);
		
		sqlSessionTemplate.update("com.crossit.hcc.dao.BoardMapper.getfmbContent", params);
	}
	public int updateHit(String seq){
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BoardMapper.updateHit", seq);
	}
}