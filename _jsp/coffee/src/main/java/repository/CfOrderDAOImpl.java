package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfOrderVO;
import orm.DataBaseBuilder;

public class CfOrderDAOImpl implements CfOrderDAO {
	private static Logger log = LoggerFactory.getLogger(CfOrderDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CfOrderMapper.";
	
	public CfOrderDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public List<CfOrderVO> selectlist(String id) {
		
		return sql.selectList(NS+"order_list", id);
	}

	@Override
	public int insert(CfOrderVO cfovo) {
		int isUp = sql.insert(NS+"reg", cfovo);
		if(isUp >0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CfOrderVO> cart_list(String id) {
		
		return sql.selectList(NS+"cart_list", id);
	}

	@Override
	public int cart_order(CfOrderVO cfovo) {
		int isUp = sql.update(NS+"order", cfovo);
		if(isUp >0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int cart_cancel(String ono) {
		int isUp = sql.delete(NS+"cel", ono);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public CfOrderVO select_id(String ono) {
		
		return sql.selectOne(NS+"getid", ono);
	}

	@Override
	public int order_cancel(String ono) {
		int isUp = sql.update(NS+"order_cancel", ono);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int order_delete(String ono) {
		int isUp = sql.delete(NS+"order_remove", ono);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CfOrderVO> host_order() {
		
		return sql.selectList(NS+"host_list");
	}

	@Override
	public int finish(String ono) {
		int isUp = sql.update(NS+"finish", ono);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int host_cancel(String ono) {
		int isUp = sql.update(NS+"host_cancel", ono);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
