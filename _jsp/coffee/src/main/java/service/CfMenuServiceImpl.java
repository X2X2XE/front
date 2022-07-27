package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfMenuVO;
import repository.CfMenuDAO;
import repository.CfMenuDAOImpl;

public class CfMenuServiceImpl implements CfMenuService {
	private static Logger log = LoggerFactory.getLogger(CfMenuServiceImpl.class);
	private CfMenuDAO cfmedao;
	
	public CfMenuServiceImpl() {
		cfmedao = new CfMenuDAOImpl();
	}
	@Override
	public int register(CfMenuVO cfmevo) {
		
		return cfmedao.insert(cfmevo);
	}
	@Override
	public List<CfMenuVO> getList() {
		
		return cfmedao.selectList();
	}
	@Override
	public CfMenuVO prd_info(String pno) {
		
		return cfmedao.selectOne(pno);
	}
	@Override
	public int modify(CfMenuVO cfmvo) {
		
		return cfmedao.update(cfmvo);
	}
	@Override
	public int remove(String pno) {
		
		return cfmedao.delect(pno);
	}
	
	@Override
	public int update_sal(CfMenuVO cfmvo) {
		
		return cfmedao.change(cfmvo);
	}
	
	

}
