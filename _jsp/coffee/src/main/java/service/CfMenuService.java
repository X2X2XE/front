package service;

import java.util.List;

import domain.CfMenuVO;

public interface CfMenuService {
	public int register(CfMenuVO cfmevo);

	public List<CfMenuVO> getList();

	public CfMenuVO prd_info(String pno);

	public int modify(CfMenuVO cfmvo);

	public int remove(String pno);

	

	public int update_sal(CfMenuVO cfMenuVO);

	
}
