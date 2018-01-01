package com.crossit.hcc.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.stream.StreamSource;

import com.crossit.hcc.vo.HospInfoBoardReplVO;
import com.crossit.hcc.vo.HospInfoBoardVO;

public interface HospInfoBoardService {

		
	// 게시글 수 조회
	public int getHospInfoCount();

	// 리스트 출력
	public List<HospInfoBoardVO> selectHospInfoBoardList(int start, int end);

	
	// 검색 후 리스트 출력
	public List<HospInfoBoardVO> searchHospInfo(int start, int end, HttpServletRequest request) throws UnsupportedEncodingException;
	
	
	// Top5 출력
	public List<HospInfoBoardVO> selectHospInfoTop5List(HttpServletRequest request);

	// 글 조회 & 조회수up
	public HospInfoBoardVO returnDetail(HttpServletRequest request);

	// 댓글 조회
	public List<HospInfoBoardReplVO> returnComment(HttpServletRequest request);
	
	// 병원정보공유 게시글 등록
	public void writeHospInfo(HttpServletRequest request, HttpSession session) throws Exception;
	
	// 병원정보공유 게시글 수정
	public void modifyHospInfo(HttpServletRequest request) throws Exception;
	
	// 병원정보공유 게시글 삭제
	public void deleteHospInfo(HttpServletRequest request);
	
	// 병원정보공유 게시판 댓글 등록
	public void writeHospInfoRepl(HttpServletRequest request);
	
	// 병원정보공유 게시판 댓글 삭제
	public void deleteHospInfoRepl(HttpServletRequest request);
	
	// 병원정보공유 게시판 대댓글 등록
	public void writeHospInfoSubRepl(HttpServletRequest request);
	
	// 병원정보공유 게시판 대댓글 삭제
	public void deleteHospInfoSubRepl(HttpServletRequest request);
	
	// 병원정보공유 게시글 신고
	public void blameHospInfo(HttpServletRequest request);
	
	// 병원정보공유 게시판 댓글 신고
	public void blameHospInfoRepl(HttpServletRequest request);
	
	// 병원정보공유 게시판 대댓글 신고
	public void blameHospInfoSubRepl(HttpServletRequest request);
	
	// 회원별 신고 횟수 증가
	public void updateblameCount(HttpSession session);
	
	
	
	
	
	
	



}