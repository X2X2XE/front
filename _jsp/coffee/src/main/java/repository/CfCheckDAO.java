package repository;

import java.util.List;

import domain.CfCheckVO;

public interface CfCheckDAO {
	public CfCheckVO check_id(String id);

	public List<CfCheckVO> selectList();
}
