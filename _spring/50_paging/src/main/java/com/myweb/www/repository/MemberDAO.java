package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface MemberDAO {
	int insert(MemberVO mvo); //register
	MemberVO selectOne(MemberVO mvo); // login
	List<MemberVO> selectList(PagingVO pgvo); // list
	MemberVO selectDetail(String email); // detail
	int update(MemberVO mvo); // modifiy
	int delete(String email); // remove
	int selectEmail(String email);
	int update_lastLog(String email);
	int selectTotalCount();
}
