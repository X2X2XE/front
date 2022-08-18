package com.misson.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misson.www.domain.AnswerVO;
import com.misson.www.domain.PagingVO;
import com.misson.www.handler.PagingHandler;
import com.misson.www.repository.AnswerDAO;
import com.misson.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Inject
	private AnswerDAO adao; 
	@Inject
	private BoardDAO bdao;
	
	@Transactional
	@Override
	public int post(AnswerVO cvo) {
		int isUp = adao.insert(cvo);
		if(isUp >0) {
			isUp = bdao.updateCmtQty(cvo.getBno(), 1);
		}
		return isUp;
	}

	@Override
	public PagingHandler spread(long bno, PagingVO pgvo) {
		
		return new PagingHandler(adao.selectList(bno, pgvo), 
				pgvo, adao.selectTotalCount(bno));
	}

	@Override
	public int modify(AnswerVO avo) {
		// TODO Auto-generated method stub
		return adao.update(avo);
	}
	
	@Transactional
	@Override
	public int remove(long cno) {
		long bno = adao.selete_bno(cno);
		int isUp = adao.delete(cno);
		if(isUp >0) {
			isUp = bdao.updateCmtQty(bno, -1);
		}
		return isUp;
	}

}
