package service;

import java.util.List;

import domain.CfCheckVO;

public interface CfCheckService {
	public CfCheckVO check_id(String id);

	public List<CfCheckVO> getList();
}
