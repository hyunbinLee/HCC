package com.crossit.hcc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HCCFmbVO;
import com.crossit.hcc.vo.HospInfoBoardReplVO;
import com.crossit.hcc.vo.HospInfoBoardVO;

@Repository
public class HospInfoMapper{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	int noOfRecords=0;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	// 페이지에 맞게 레코트 출력
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
	
	
	// 레코드 수 출력
	public int getNoOfRecords() {	 
        return noOfRecords;
	}
	
	
	// 리스트 출력
	public List<HospInfoBoardVO> selectHospInfoBoardList() {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.selectHospInfoBoardList");
	}

	public List<HospInfoBoardVO> getHospInfoList(int start, int end) {
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("start", start); 
		map.put("end",  end);
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.getHospInfoList", map);
	}
	
	public int getHospInfoCount() {
		int count = sqlSessionTemplate.selectOne("com.crossit.hcc.dao.HospInfoMapper.getHospInfoCount");
		
		System.out.println("========================="+count+"==========================");
		return count;
	}
	
	public List<HospInfoBoardVO> selectHospInfoTop5List() {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.selectHospInfoTop5List");
	}
	
	public HospInfoBoardVO returnDetail(int boardseq) {
		return sqlSessionTemplate.selectOne("com.crossit.hcc.dao.HospInfoMapper.returnDetail", boardseq);
	}

	public List<HospInfoBoardReplVO> returnComment(int boardseq) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.returnComm", boardseq);
	}

	public void updateHitCount(int boardseq) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.updateHitCount", boardseq);
	}

	public void writeHospInfo(Map<String,Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapper.writeHospInfo", map);
	}

	public void modifyHospInfo(Map<String,Object> map) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.modifyHospInfo", map);
	}

	public void deleteHospInfo(int boardseq) {
		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapper.deleteHospInfo", boardseq);
	}

	public void writeHospInfoRepl(Map<String,Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapper.writeHospInfoRepl", map);
	}

	public void deleteHospInfoRepl(Map<String,Object> map) {
		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapper.deleteHospInfoRepl", map);		
	}

	public void writeHospInfoSubRepl(Map<String,Object> map) {
		sqlSessionTemplate.insert("com.crossit.hcc.dao.HospInfoMapper.writeHospInfoSubRepl", map);
	}

	public void deleteHospInfoSubRepl(Map<String,Object> map) {
		sqlSessionTemplate.delete("com.crossit.hcc.dao.HospInfoMapper.deleteHospInfoSubRepl", map);		
	}

	public void blameHospInfo(int boardseq) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.blameHospInfo", boardseq);
	}

	public void blameHospInfoRepl(Map<String,Object> map) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.blameHospInfoRepl", map);
	}

	public void blameHospInfoSubRepl(Map<String,Object> map) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.blameHospInfoSubRepl", map);
	}

	public void updateblameCount(int userseq) {
		sqlSessionTemplate.update("com.crossit.hcc.dao.HospInfoMapper.updateblameCount", userseq);
	}

	
	
	
	//-----------------검색 후 결과출력------------------// 
	public List<HospInfoBoardVO> searchHospInfo1(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo1", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo2(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo2", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo3(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo3", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo4(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo4", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo5(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo5", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo6(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo6", map);
	}
	
	public List<HospInfoBoardVO> searchHospInfo7(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("com.crossit.hcc.dao.HospInfoMapper.searchHospInfo7", map);
	}
	
	
	
	


	

	

	


	


	


	
	
	

}