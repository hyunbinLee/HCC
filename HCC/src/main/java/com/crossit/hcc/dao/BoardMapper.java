package com.crossit.hcc.dao;

import java.util.List;

import com.crossit.hcc.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> selectRecordsPerPage(int offset, int noOfRecords);
	public int selectTotalRecords();
}
