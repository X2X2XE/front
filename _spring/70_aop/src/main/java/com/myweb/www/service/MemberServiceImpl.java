package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.FileDAO;
import com.myweb.www.repository.MemberDAO;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mdao;
	@Inject
	private FileDAO fdao;
	@Override
	public int register(MemberDTO mdto) {
		int isUp = mdao.insert(mdto.getMvo());
		
		if(isUp > 0 && mdto.getFile()!=null) {
			mdto.getFile().setEmail(mdto.getMvo().getEmail());
			isUp *= fdao.insert_user_th(mdto.getFile());
		}
		
		return isUp;
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectOne(mvo);
	}

	@Override
	public List<MemberVO> list(PagingVO pgvo) {
		return mdao.selectList(pgvo);
	}

	@Override
	public MemberDTO detail(String email) {
		return new MemberDTO(mdao.selectDetail(email), fdao.selectFile(email)) ;
	}

	@Override
	public int modifiy(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		return mdao.delete(email);
	}

	@Override
	public int dupleCheck(String email) {
		return mdao.selectEmail(email);
	}

	@Override
	public int modlog(String email) {
		// TODO Auto-generated method stub
		return mdao.update_lastLog(email);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return mdao.selectTotalCount(pgvo);
	}

}
