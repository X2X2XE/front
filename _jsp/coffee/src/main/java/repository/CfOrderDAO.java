package repository;

import java.util.List;

import domain.CfOrderVO;

public interface CfOrderDAO {
	public List<CfOrderVO>selectlist(String id);

	public int insert(CfOrderVO cfovo);

	public List<CfOrderVO> cart_list(String id);

	public int cart_order(CfOrderVO cfovo);

	public int cart_cancel(String ono);

	public CfOrderVO select_id(String ono);

	public int order_cancel(String ono);

	public int order_delete(String ono);

	public List<CfOrderVO> host_order();

	public int finish(String ono);

	public int host_cancel(String ono);
	
	
}
