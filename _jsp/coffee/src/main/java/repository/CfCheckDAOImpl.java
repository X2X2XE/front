package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfCheckVO;
import orm.DataBaseBuilder;

public class CfCheckDAOImpl implements CfCheckDAO {
	private static Logger log = LoggerFactory.getLogger(CfCheckDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CfCheckMapper.";
	
	public CfCheckDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	@Override
	public CfCheckVO check_id(String id) {

		return sql.selectOne(NS+"check", id);
	}
	@Override
	public List<CfCheckVO> selectList() {
		
		return sql.selectList(NS+"list");
	}

}
