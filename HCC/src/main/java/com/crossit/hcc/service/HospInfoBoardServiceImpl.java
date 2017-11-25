package com.crossit.hcc.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	//HospInfoMapper HospInfoMapper = new HospInfoMapper();
	PageNavigation paging;
	int currentPageNo;
	int recordsPerPage;
	int start;
	int end;
		
		
	
	
	// 게시글 수 조회
	@Override
	public int getHospInfoCount() {
		return HospInfoMapper.getHospInfoCount();
	}

	// 리스트 출력
	@Override
	public List<HospInfoBoardVO> selectHospInfoBoardList(HttpServletRequest request) {		
		return HospInfoMapper.selectHospInfoBoardList();
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
		title =new String(title.getBytes("8859_1"),"utf-8");
		
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		
				
		Map<String,Object> map = new HashMap<String, Object>(); 
			
		map.put("title", title); // 제목
		map.put("content",  content); // 내용
		map.put("writerseq", userseq); // 작성자seq
		map.put("star", request.getParameter("star")); //별점
			
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
		
		

	
















	
	
	
	// 페이징처리 한 리스트 출력
	public Map<String,Object> hospInfoList(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page)
	{	
		
		Map<String,Object> map = new HashMap<String, Object>(); 
		
		HospInfoBoardServiceImpl pagingImpl = new HospInfoBoardServiceImpl(page);
		
		int start = pagingImpl.getStart();
		int end = pagingImpl.getEnd();
		
		//전체 게시물 수
		pagingImpl.setNumberOfRecords(HospInfoMapper.getHospInfoCount());
		
		//마지막 페이지 번호
		pagingImpl.makePaging();
		
		map.put("page", page);
		map.put("startPage", pagingImpl.getStartPageNo());
		map.put("endPage", pagingImpl.getEndPageNo());
		map.put("list",HospInfoMapper.getHospInfoList(start, end));
		map.put("lastPage", pagingImpl.getFinalPageNo());

		return map;
	}
	
	
    public List<BoardVO> selectRecordsPerPage(int offset, int noOfRecords) {
        return HospInfoMapper.selectRecordsPerPage(offset, noOfRecords);
    }
    public HospInfoBoardServiceImpl(){
    	
    }
	public HospInfoBoardServiceImpl(String page) {
		try {
			currentPageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			currentPageNo = 1;
		}
		
		if(page != null) {
			currentPageNo = Integer.parseInt(page);
		}
		recordsPerPage = 5; //페이지당 5개의 게시물
		
		paging = new PageNavigation(currentPageNo, recordsPerPage);
		
		//호출할 페이지 레코드 번호
		start = (currentPageNo -1)* paging.getRecordsPerPage() +1;
		end = currentPageNo * paging.getRecordsPerPage();
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public void setNumberOfRecords(int numberOfRecords) {
		paging.setNumberOfRecords(numberOfRecords);
	}
	public int getFinalPageNo() {
		return paging.getFinalPageNo();
	}
	public void makePaging() {
		paging.makePaging();
	}
	public int getStartPageNo() {
		return paging.getStartPageNo();
	}
	public int getEndPageNo() {
		return paging.getEndPageNo();
	}
	
}