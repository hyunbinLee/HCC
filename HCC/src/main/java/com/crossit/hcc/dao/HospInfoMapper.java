package com.crossit.hcc.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crossit.hcc.vo.HospInfoReplVO;
import com.crossit.hcc.vo.HospInfoVO;



public interface HospInfoMapper {

	// 페이지 별 리스트 출력 
	public List<HospInfoVO> getHospInfoList(int start, int end);
	
	// 페이징 처리
	public int getHospInfoCount();
	
	// 리스트 출력
	public List<HospInfoVO> selectHospInfoBoardList();

	// Top5 출력
	public List<HospInfoVO> selectHospInfoTop5List();
	
	// 글 조회
	public HospInfoVO returnDetail(HttpServletRequest request);
	
	// 댓글 조회
	public List<HospInfoReplVO> returnComment(HttpServletRequest request);

	// 조회수 up
	public void updateHitCount(HttpServletRequest request);

	// 병원정보공유 게시글 등록
	public void writeHospInfo(HttpServletRequest request);

	// 병원정보공유 게시글 수정
	public void modifyHospInfo(HttpServletRequest request);
	
	// 병원정보공유 게시글 삭제
	public void deleteHospInfo(HttpServletRequest request);

	// 댓글 등록
	public void writeHospInfoRepl(HttpServletRequest request);

	// 댓글 삭제
	public void deleteHospInfoRepl(HttpServletRequest request);

	// 대댓글 등록
	public void writeHospInfoSubRepl(HttpServletRequest request);
	
	// 대댓글 삭제
	public void deleteHospInfoSubRepl(HttpServletRequest request);
	
	// 게시글 신고
	public void blameHospInfo(HttpServletRequest request);
	
	// 댓글 신고
	public void blameHospInfoRepl(HttpServletRequest request);
	
	// 대댓글 신고
	public void blameHospInfoSubRepl(HttpServletRequest request);

	// 회원별 신고 횟수 증가
	public void updateblameCount(HttpSession session);

	

	

	


	// 모든 쿼리에 작성자인지 아닌지 확인하는 코드 추가
	
	// 좋아요, 싫어요
	

	
	
	
}
