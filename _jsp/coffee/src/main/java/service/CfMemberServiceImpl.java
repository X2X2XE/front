package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfMemberVO;
import repository.CfMemberDAO;
import repository.CfMemberDAOImpl;

public class CfMemberServiceImpl implements CfMemberService {
	private static Logger log = LoggerFactory.getLogger(CfMemberServiceImpl.class);
	private CfMemberDAO cfdao;
	
	public CfMemberServiceImpl() {
		cfdao = new CfMemberDAOImpl();
	}
	
	@Override
	public int register(CfMemberVO cfmvo) {

		return cfdao.insert(cfmvo);
	}

	@Override
	public CfMemberVO check_id(String id) {

		return cfdao.idcheck(id);
	}

	@Override
	public CfMemberVO detail(String id) {

		return cfdao.selectOne(id);
	}

	@Override
	public CfMemberVO login(CfMemberVO cfmvo) {
		
		return cfdao.selectOne(cfmvo);
	}

	@Override
	public int modify(CfMemberVO cfmvo) {
		
		return cfdao.update(cfmvo);
	}

	@Override
	public int remove(String id) {
		
		return cfdao.delect(id);
	}

}
