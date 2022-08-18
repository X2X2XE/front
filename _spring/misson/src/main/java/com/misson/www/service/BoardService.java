package com.misson.www.service;

import java.util.List;

import com.misson.www.domain.BoardDTO;
import com.misson.www.domain.BoardVO;
import com.misson.www.domain.PagingVO;

public interface BoardService {
	int register(BoardDTO bdto);
	List<BoardVO> getList(PagingVO pgvo);
	BoardDTO getDetail(long bno, int i);
	int modifiy(BoardDTO bdto);
	int remove(long bno);
	int getTotalCount(PagingVO pgvo);
	int removeFile(String uuid);
}
