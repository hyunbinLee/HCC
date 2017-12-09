package com.crossit.hcc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.util.PageNavigation;
import com.crossit.hcc.vo.BoardVO;
import com.crossit.hcc.vo.UserVO;

@Service("BoardService")
public class BoardService {

	BoardMapperImpl boardDao = new BoardMapperImpl();
	PageNavigation paging;
	int currentPageNo;
	int recordsPerPage;
	int start;
	int end;
	
    public List<BoardVO> selectRecordsPerPage(int offset, int noOfRecords) {
        
        return boardDao.selectRecordsPerPage(offset, noOfRecords);
    }

    public BoardMapperImpl getBoardDao() {
    	 
        return boardDao;
    }
    public BoardService(){
    	
    }
	public BoardService(String page) {
		try {
			currentPageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			currentPageNo = 1;
		}
		
		if(page != null) {
			currentPageNo = Integer.parseInt(page);
		}
		recordsPerPage = 5; //�럹�씠吏��떦 5媛쒖쓽 寃뚯떆臾�
		
		paging = new PageNavigation(currentPageNo, recordsPerPage);
		
		//�샇異쒗븷 �럹�씠吏� �젅肄붾뱶 踰덊샇
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
	
	public String fmbWriteAction(HttpSession session,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content = new String(content.getBytes("8859_1"),"utf-8");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail vo = (UserDetail)auth.getPrincipal();
	      
	    UserVO v1 = vo.getUser();
	    int user_seq = v1.getUser_seq();
		String type = request.getParameter("select");
		String status = request.getParameter("status");
		
		
		boardDao.writefmb(title, content,user_seq,type,status);
		
		return "redirect:fmbList?page=1";
	}
	public int deleteListAction(HttpSession session,HttpServletRequest request){
		String seq = request.getParameter("seq");

		return boardDao.deleteList(seq);
	}
	public String updateList(HttpServletRequest request) throws Exception {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		title =new String(title.getBytes("8859_1"),"utf-8");
		String content = request.getParameter("content");
		content =new String(content.getBytes("8859_1"),"utf-8");
		
		boardDao.updateList(seq, title, content);
		
		return "redirect:fmbList?page=1";
	}
	//댓글 작성
	public String replyWriteAction(HttpSession session,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetail vo = (UserDetail)auth.getPrincipal();
	      
	    UserVO v1 = vo.getUser();
	    int user_seq = v1.getUser_seq();
		
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
		String comment = request.getParameter("comment");
		
		boardDao.writeReply(seq, user_seq, comment);
		
		return "redirect:fmbContentPage?seq=" + seq;
	}
	
	public int replyDeleteAction(HttpSession session,HttpServletRequest request){
		String seq = request.getParameter("seq");

		return boardDao.deleteReply(seq);
	}
}
