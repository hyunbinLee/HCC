package com.crossit.hcc.service;

import java.util.List;

import com.crossit.hcc.dao.BoardMapperImpl;
import com.crossit.hcc.vo.BoardVO;

public class BoardService {

	BoardMapperImpl boardDao = new BoardMapperImpl();
	
    public List<BoardVO> selectRecordsPerPage(int offset, int noOfRecords) {
        
        return boardDao.selectRecordsPerPage(offset, noOfRecords);
    }

    public BoardMapperImpl getBoardDao() {
    	 
        return boardDao;
    }

    
    


}
