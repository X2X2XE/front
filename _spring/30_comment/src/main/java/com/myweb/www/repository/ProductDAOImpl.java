package com.myweb.www.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.www.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private final String NS="ProductMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int insert(ProductVO pvo) {
		
		return sql.insert(NS+"reg",pvo);
	}

	@Override
	public List<ProductVO> selectList() {
		// TODO Auto-generated method stub
		return sql.selectList(NS+"list");
	}

	@Override
	public ProductVO selectOne(long pno) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"detail", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		// TODO Auto-generated method stub
		return sql.update(NS+"mod", pvo);
	}

	@Override
	public int delete(long pno) {
		// TODO Auto-generated method stub
		return sql.delete(NS+"del", pno);
	}

}
