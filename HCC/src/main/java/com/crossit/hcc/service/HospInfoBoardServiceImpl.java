package com.crossit.hcc.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossit.hcc.dao.HospInfoMapper;
import com.crossit.hcc.util.PageNavigation;
import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.HospInfoBoardReplVO;
import com.crossit.hcc.vo.HospInfoBoardVO;
import com.crossit.hcc.vo.UserVO;

@Service("HospInfoBoardService")
public class HospInfoBoardServiceImpl implements HospInfoBoardService{
		
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private HospInfoMapper HospInfoMapper;	
	


	
	// 게시글 수 조회
	@Override
	public int getHospInfoCount() {
		return HospInfoMapper.getHospInfoCount();
	}
	
	// 리스트 출력 - 페이징처리
	@Override
	public List<HospInfoBoardVO> selectHospInfoBoardList(int start, int end) {		
		return HospInfoMapper.getHospInfoList(start, end);
	}
	
	
	
	// 검색 후 결과 출력
	public List<HospInfoBoardVO> searchHospInfo(int start, int end, HttpServletRequest request) throws UnsupportedEncodingException {
		
		String searchType = request.getParameter("searchType");
		char searchCase = request.getParameter("searchCase").charAt(0);
		String searchWord = request.getParameter("searchWord");
		searchWord = new String(searchWord.getBytes("8859_1"),"utf-8");
		
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("searchCase", searchCase);
		map.put("searchWord", searchWord);
		map.put("start", start);
		map.put("end", end);
			
		if(searchWord == "") { 
			if(searchCase == 'Z') { // 검색키워드X, 진료과목선택 X
				return HospInfoMapper.getHospInfoList(start, end);
			} else { // 검색키워드 X, 진료과목선택 O
				return HospInfoMapper.searchHospInfo1(map);
			}
		} else { // 검색키워드 O
			if(searchType.equals("title") && searchCase == 'Z') { // 제목만 검색, 진료과목선택 X
				return HospInfoMapper.searchHospInfo2(map);
			} else if(searchType.equals("title") && searchCase != 'Z') { // 제목만 검색, 진료과목선택 O
				return HospInfoMapper.searchHospInfo3(map);
			} else if(searchType.equals("name") && searchCase == 'Z') { // 작성자만 검색, 진료과목선택 X
				return HospInfoMapper.searchHospInfo4(map);
			} else if(searchType.equals("name") && searchCase != 'Z') { // 작성자만 검색, 진료과목선택 O
				return HospInfoMapper.searchHospInfo5(map);
			} else if(searchType.equals("all") && searchCase == 'Z') { // 제목+작성자 검색, 진료과목선택 X
				return HospInfoMapper.searchHospInfo6(map);
			} else { // 제목+작성자 검색, 진료과목선택 O
				return HospInfoMapper.searchHospInfo7(map);
			}
		}
			
		
	}
	
	
	// Top5 출력
	@Override
	public List<HospInfoBoardVO> selectHospInfoTop5List(HttpServletRequest request) {
		return HospInfoMapper.selectHospInfoTop5List();
	}
		
	// 글 조회 & 조회수up
	@Override
	public HospInfoBoardVO returnDetail(HttpServletRequest request){
			
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		
		HospInfoMapper.updateHitCount(boardseq);
		return HospInfoMapper.returnDetail(boardseq);
	}

	// 댓글 조회
	@Override
	public List<HospInfoBoardReplVO> returnComment(HttpServletRequest request){
			
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
			
		return HospInfoMapper.returnComment(boardseq);
	}

	// 병원정보공유 게시글 등록
	@Override
	public void writeHospInfo(HttpServletRequest request, HttpSession session) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail vo = (UserDetail)auth.getPrincipal();
	    UserVO v1 = vo.getUser();
	    int userseq = v1.getUser_seq();
	    
	    String title = request.getParameter("title");
		title = new String(title.getBytes("8859_1"),"utf-8");
		
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		String hospnm = request.getParameter("hospnm");
		hospnm = new String(content.getBytes("8859_1"),"utf-8");
				
		Map<String,Object> map = new HashMap<String, Object>(); 
			
		map.put("title", title); // 제목
		map.put("content",  content); // 내용
		map.put("writerseq", userseq); // 작성자seq
		map.put("star", request.getParameter("star")); // 별점
		map.put("hospnm", hospnm); // 병원이름
		map.put("class", request.getParameter("class")); // 진료과
		map.put("type", request.getParameter("type")); // 타입(성인, 소아)
		
		HospInfoMapper.writeHospInfo(map);
	}
		
	// 병원정보공유 게시글 수정
	@Override
	public void modifyHospInfo(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
			
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		
		
		Map<String,Object> map = new HashMap<String, Object>(); 
			
		map.put("boardseq", request.getParameter("boardseq"));
		map.put("title", title); // 제목
		map.put("content", content); // 내용
		map.put("star", request.getParameter("star")); //별점
		
		HospInfoMapper.modifyHospInfo(map);
	}
		
	// 병원정보공유 게시글 삭제
	@Override
	public void deleteHospInfo(HttpServletRequest request){
		
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
		
		HospInfoMapper.deleteHospInfo(boardseq);
	}

	// 병원정보공유 게시판 댓글 등록
	@Override
	public void writeHospInfoRepl(HttpServletRequest request) {
			
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("comment",  request.getParameter("comment").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
		
		HospInfoMapper.writeHospInfoRepl(map);
	}
	
	// 병원정보공유 게시판 댓글 삭제
	@Override
	public void deleteHospInfoRepl(HttpServletRequest request) {
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq")));
		HospInfoMapper.deleteHospInfoRepl(map);
	}
		
	// 병원정보공유 게시판 대댓글 등록
	@Override
	public void writeHospInfoSubRepl(HttpServletRequest request) {
		
		Map<String,Object> map = new HashMap<String, Object>(); 
			
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("comment",  request.getParameter("comment").toString()); // 내용
		map.put("writerseq", Integer.parseInt(request.getParameter("writerseq"))); // 작성자seq
			
		HospInfoMapper.writeHospInfoSubRepl(map);
	}
		
	// 병원정보공유 게시판 대댓글 삭제
	@Override
	public void deleteHospInfoSubRepl(HttpServletRequest request) {
			
		Map<String,Object> map = new HashMap<String, Object>(); 
			
		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("replysubseq", Integer.parseInt(request.getParameter("replysubseq"))); // 대댓글seq
			
		HospInfoMapper.deleteHospInfoSubRepl(map);
	}
		
	// 병원정보공유 게시글 신고
	@Override
	public void blameHospInfo(HttpServletRequest request) {
			
		int boardseq = Integer.parseInt(request.getParameter("boardseq"));
			
		HospInfoMapper.blameHospInfo(boardseq);
	}
		
	// 병원정보공유 게시판 댓글 신고
	@Override
	public void blameHospInfoRepl(HttpServletRequest request) {
			
		Map<String,Object> map = new HashMap<String, Object>(); 

		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
			
		HospInfoMapper.blameHospInfoRepl(map);
	}
		
	// 병원정보공유 게시판 대댓글 신고
	@Override
	public void blameHospInfoSubRepl(HttpServletRequest request) {
				
		Map<String,Object> map = new HashMap<String, Object>(); 

		map.put("boardseq", Integer.parseInt(request.getParameter("boardseq")));
		map.put("replyseq", Integer.parseInt(request.getParameter("replyseq"))); // 댓글seq
		map.put("replysubseq", Integer.parseInt(request.getParameter("replysubseq"))); // 대댓글seq
				
		HospInfoMapper.blameHospInfoSubRepl(map);
	}
		
	// 회원별 신고 횟수 증가
	@Override
	public void updateblameCount(HttpSession session) {
			
		int userseq = Integer.parseInt(session.getAttribute("userseq").toString());
			
		HospInfoMapper.updateblameCount(userseq);
	}
		
	

}