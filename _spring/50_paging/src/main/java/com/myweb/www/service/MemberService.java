package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface MemberService {
	int register(MemberVO mvo);
	MemberVO login(MemberVO mvo);
	List<MemberVO> list(PagingVO pgvo);
	MemberVO detail(String email);
	int modifiy(MemberVO mvo);
	int remove(String email);
	int dupleCheck(String email);
	int modlog(String email);
	int getTotalCount();
}