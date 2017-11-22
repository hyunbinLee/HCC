package com.crossit.hcc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crossit.hcc.vo.HospInfoReplVO;
import com.crossit.hcc.vo.HospInfoVO;

public interface HospInfoBoardService {


	// 게시글 수 조회
	public int getHospInfoCount();

	// 리스트 출력
	public List<HospInfoVO> selectHospInfoBoardList(HttpServletRequest request);	

	// Top5 출력
	public List<HospInfoVO> selectHospInfoTop5List(HttpServletRequest request);

	// 글 조회
	public HospInfoVO returnDetail(HttpServletRequest request);

	// 댓글 조회
	public List<HospInfoReplVO> returnComment(HttpServletRequest request);

	// 조회수 up
	public void updateHitCount(HttpServletRequest request);
	
	// 병원정보공유 게시글 등록
	public void writeHospInfo(HttpServletRequest request, HttpSession session);
	
	// 병원정보공유 게시글 수정
	public void modifyHospInfo(HttpServletRequest request);
	
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