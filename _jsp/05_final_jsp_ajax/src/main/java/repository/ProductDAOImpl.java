package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import orm.DataBaseBuilder;

public class ProductDAOImpl implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SqlSession sql;
	private final String NS = "ProductMapper.";
	private int isUp;
	
	public ProductDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(ProductVO pvo) {
		isUp = sql.insert(NS+"add", pvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ProductVO> selectList() {
		
			
		return sql.selectList(NS+"list");
	}

	@Override
	public ProductVO selectOne(int pno) {
		
		return sql.selectOne(NS+"selOne",pno);
	}

	@Override
	public int update(ProductVO pvo) {
		isUp = sql.update(NS+"mod", pvo);
		if(isUp >0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(int pno) {
		isUp = sql.delete(NS+"del", pno);
		if(isUp >0) {
			sql.commit();
		}
		return isUp;
	}
}
