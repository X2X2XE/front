package com.misson.www.service;

import java.util.List;

import com.misson.www.domain.AnswerVO;
import com.misson.www.domain.PagingVO;
import com.misson.www.handler.PagingHandler;



public interface AnswerService {
	int post(AnswerVO avo);
	PagingHandler spread(long bno, PagingVO pgvo);
	int modify(AnswerVO avo);
	int remove(long cno);
	
	
	
}
