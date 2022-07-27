package service;

import domain.CfMemberVO;

public interface CfMemberService {
	public int register(CfMemberVO cfmvo);
	public CfMemberVO check_id(String id);
	public CfMemberVO detail(String id);
	public CfMemberVO login(CfMemberVO cfMemberVO);
	
	public int modify(CfMemberVO cfmvo);
	public int remove(String id);
}
