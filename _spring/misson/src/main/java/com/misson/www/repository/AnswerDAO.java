package com.misson.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.misson.www.domain.AnswerVO;
import com.misson.www.domain.PagingVO;


public interface AnswerDAO {
	int insert(AnswerVO avo);
	List<AnswerVO> selectList(@Param("bno") long bno,@Param("pgvo") PagingVO pgvo);
	int update(AnswerVO avo);
	int delete(long cno);
	int selectTotalCount(long bno);
	long selete_bno(long cno);
}
