package repository;

import domain.CfMemberVO;

public interface CfMemberDAO {

	public int insert(CfMemberVO cfmvo);
	public CfMemberVO idcheck(String id);
	public CfMemberVO selectOne(String id);
	public CfMemberVO selectOne(CfMemberVO cfmvo);
	
	public int update(CfMemberVO cfmvo);
	public int delect(String id);
}
