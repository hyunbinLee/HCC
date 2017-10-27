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
	public void writefmb(String title, String content, int user_seq, String type, String status) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("title", title);
		params.put("content", content);
		params.put("user_seq", user_seq);
		params.put("type", type);
		params.put("status", status);
		sqlSessionTemplate.insert("com.crossit.hcc.dao.BoardMapper.writefmb",params);
	}
	@Override
	public void deleteList(String seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("com.crossit.hcc.dao.BoardMapper.deleteList", seq);
	}

	@Override
	public List<HCCFmbVO> getfmbList(int start, int end) {
		// TODO Auto-generated method stub	
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("param1", String.valueOf(start));
		params.put("param2", String.valueOf(end));
		params.put("param", 'D');////////////////일단 의사 게시물만 보이게 해놨음 . 추 후에 버튼 만들어서 의사 환자 교대로 보여줘야할듯
		
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
		
		sqlSessionTemplate.update("com.crossit.hcc.dao.BoardMapper.updateList", params);
	}
	public int updateHit(String seq){
		return sqlSessionTemplate.update("com.crossit.hcc.dao.BoardMapper.updateHit", seq);
	}
	public int likeList(String seq){
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("seq", seq);
		return sqlSessionTemplate.update("com.crossit.hcc.dao.BoardMapper.likeList", seq);
	}
	public int unlikeList(String seq){
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("seq", seq);
		return sqlSessionTemplate.update("com.crossit.hcc.dao.BoardMapper.unlikeList", seq);
	}
}