package com.crossit.hcc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HCCFmbVO;
import com.crossit.hcc.vo.HCCFmb_replyVO;

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
	public int deleteList(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("com.crossit.hcc.dao.BoardMapper.deleteList", seq);
	}

	@Override
	public List<HCCFmbVO> getfmbList(int start, int end) {
		// TODO Auto-generated method stub	
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("param1", String.valueOf(start));
		params.put("param2", String.valueOf(end));
		params.put("param", 'D');////////////////�씪�떒 �쓽�궗 寃뚯떆臾쇰쭔 蹂댁씠寃� �빐�넧�쓬 . 異� �썑�뿉 踰꾪듉 留뚮뱾�뼱�꽌 �쓽�궗 �솚�옄 援먮�濡� 蹂댁뿬以섏빞�븷�벏
		
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.BoardMapper.getfmbList", params);
	}
	@Override
	public HCCFmbVO getfmbContent(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.BoardMapper.getfmbContent", seq);
	}
	public List<Object> getReplyContent(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.BoardMapper.getReplyContent", seq);
	}
	@Override
	public void updateList(int seq, String title, String content) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("seq", seq);
		params.put("title", title);
		params.put("content", content);
		
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
	
	//댓글
	public void writeReply(int seq, int user_seq, String comment){
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("seq", seq);
		params.put("comment", comment);
		params.put("user_seq", user_seq);
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.BoardMapper.replyWrite", params);
	}

	public int deleteReply(String seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("com.crossit.hcc.dao.BoardMapper.deleteReply", seq);
	}
}