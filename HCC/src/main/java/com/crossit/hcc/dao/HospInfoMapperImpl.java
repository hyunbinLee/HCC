package com.crossit.hcc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.HospInfoReplVO;
import com.crossit.hcc.vo.HospInfoVO;

@Service
@Configurable
public class HospInfoMapperImpl implements HospInfoMapper{

	
	private SqlSessionTemplate sqlSessionTemplate;


	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	@Override
	public List<HospInfoVO> selectHospInfoBoardList() {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapperImpl.selectHospInfoBoardList");
	}
	
	@Override
	public List<HospInfoVO> getHospInfoList(int start, int end) {
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("start", start); 
		map.put("end",  end);
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapperImpl.getHospInfoList", map);
	}
	
	@Override
	public int getHospInfoCount() {
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.HospInfoMapperImpl.getHospInfoCount");
	}
	
	@Override
	public List<HospInfoVO> selectHospInfoTop5List() {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapperImpl.selectHospInfoTop5List");
	}
	
	@Override
	public HospInfoVO returnDetail(HttpServletRequest request) {
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));

		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.HospInfoMapperImpl.returnDetail", boardseq);
	}

	@Override
	public List<HospInfoReplVO> returnComment(HttpServletRequest request) {
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));

		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapperImpl.returnComment", boardseq);
	}

	@Override
	public void updateHitCount(HttpServletRequest request) {
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.updateHitCount", boardseq);
	}

	@Override
	public void writeHospInfo(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("title", request.getParameter("title").toString()); // 제목
		map.put("content",  request.getParameter("content").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
		map.put("star", Double.parseDouble(request.getParameter("star"))); //별점
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapperImpl.writeHospInfo", map);
	}

	@Override
	public void modifyHospInfo(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("title", request.getParameter("title").toString()); // 제목
		map.put("content",  request.getParameter("content").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
		map.put("star", Double.parseDouble(request.getParameter("star"))); //별점
		
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.modifyHospInfo", map);
	}

	@Override
	public void deleteHospInfo(HttpServletRequest request) {
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));

		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapperImpl.deleteHospInfo", boardseq);
	}

	@Override
	public void writeHospInfoRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("comment",  request.getParameter("comment").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapperImpl.writeHospInfoRepl", map);
	}

	@Override
	public void deleteHospInfoRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq")));

		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapperImpl.deleteHospInfoRepl", map);		
	}

	@Override
	public void writeHospInfoSubRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("comment",  request.getParameter("comment").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
		
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapperImpl.writeHospInfoSubRepl", map);
	}

	@Override
	public void deleteHospInfoSubRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("replysubseq", Integer.parseInt(request.getParameter("replysubseq"))); // 대댓글seq
		
		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapperImpl.deleteHospInfoSubRepl", map);		
	}

	@Override
	public void blameHospInfo(HttpServletRequest request) {
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));

		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.blameHospInfo", boardseq);
	}

	@Override
	public void blameHospInfoRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 

		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.blameHospInfoRepl", map);
	}

	@Override
	public void blameHospInfoSubRepl(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>(); 

		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("replysubseq", Integer.parseInt(request.getParameter("replysubseq"))); // 대댓글seq
			
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.blameHospInfoSubRepl", map);
	}

	@Override
	public void updateblameCount(HttpSession session) {
		int userseq = Integer.parseInt(session.getAttribute("userseq").toString());

		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapperImpl.updateblameCount", userseq);
	}

	


	


	


	
	
	

}
