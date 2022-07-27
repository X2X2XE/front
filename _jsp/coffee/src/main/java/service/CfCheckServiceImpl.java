package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfCheckVO;
import repository.CfCheckDAO;
import repository.CfCheckDAOImpl;

public class CfCheckServiceImpl implements CfCheckService {
	private static Logger log = LoggerFactory.getLogger(CfCheckServiceImpl.class);
	private CfCheckDAO cfcdao;
	
	public CfCheckServiceImpl() {
		cfcdao = new CfCheckDAOImpl();
	}
	@Override
	public CfCheckVO check_id(String id) {

		return cfcdao.check_id(id);
	}
	@Override
	public List<CfCheckVO> getList() {
		
		return cfcdao.selectList();
	}

}
