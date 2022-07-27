package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfOrderVO;
import repository.CfOrderDAO;
import repository.CfOrderDAOImpl;

public class CfOrderServiceImpl implements CfOrderService {
	private static Logger log = LoggerFactory.getLogger(CfOrderServiceImpl.class);
	private CfOrderDAO cfodao;
	
	public CfOrderServiceImpl() {
		cfodao = new CfOrderDAOImpl();
	}


	@Override
	public int cart_add(CfOrderVO cfovo) {
		
		return cfodao.insert(cfovo);
	}

	@Override
	public List<CfOrderVO> cart_list(String id) {
		
		return cfodao.cart_list(id);
	}

	@Override
	public int cart_order(CfOrderVO cfovo) {
		
		return cfodao.cart_order(cfovo);
	}

	@Override
	public int cart_cancel(String ono) {
		
		return cfodao.cart_cancel(ono);
	}

	@Override
	public CfOrderVO getid(String ono) {
		
		return cfodao.select_id(ono);
	}


	@Override
	public List<CfOrderVO> order_list(String id) {
		
		return cfodao.selectlist(id);
	}


	@Override
	public int order_cancel(String ono) {
		
		return cfodao.order_cancel(ono);
	}


	@Override
	public int order_remove(String ono) {
		
		return cfodao.order_delete(ono);
	}


	@Override
	public List<CfOrderVO> host_order() {
		
		return cfodao.host_order();
	}


	@Override
	public int host_finish(String ono) {
		
		return cfodao.finish(ono);
	}


	@Override
	public int host_cancel(String ono) {
		
		return cfodao.host_cancel(ono);
	}

}
