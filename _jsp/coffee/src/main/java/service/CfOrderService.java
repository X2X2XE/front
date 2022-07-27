package service;

import java.util.List;

import domain.CfOrderVO;

public interface CfOrderService {
	int cart_add(CfOrderVO cfOrderVO);

	List<CfOrderVO> cart_list(String id);

	int cart_order(CfOrderVO cfovo);

	int cart_cancel(String ono);

	CfOrderVO getid(String ono);

	List<CfOrderVO> order_list(String id);

	int order_cancel(String ono);

	int order_remove(String parameter);

	List<CfOrderVO> host_order();

	int host_finish(String parameter);

	int host_cancel(String parameter);
}
