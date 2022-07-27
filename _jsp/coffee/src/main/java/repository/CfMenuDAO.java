package repository;

import java.util.List;

import domain.CfMenuVO;

public interface CfMenuDAO {
	public int insert(CfMenuVO cfmevo);

	public List<CfMenuVO> selectList();

	public CfMenuVO selectOne(String pno);

	public int update(CfMenuVO cfmvo);

	public int delect(String pno);

	public int change(CfMenuVO cfmvo);
}
