package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO pdao;
	
	@Override
	public int register(ProductVO pvo) {
		// TODO Auto-generated method stub
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return pdao.selectList(pgvo);
	}


	@Override
	public ProductVO getDetail(long pno) {
		// TODO Auto-generated method stub
		return pdao.selectOne(pno);
	}

	@Override
	public int modifiy(ProductVO pvo) {
		// TODO Auto-generated method stub
		return pdao.update(pvo);
	}

	@Override
	public int remove(long pno) {
		// TODO Auto-generated method stub
		return pdao.delete(pno);
	}

	@Override
	public int getTotalCount() {
		
		return pdao.selectTotalCount();
	}

}
