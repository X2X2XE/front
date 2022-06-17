package repository;

import java.util.List;

import domain.ProductVO;

public interface DAO {

	int insert(ProductVO pvo); // Data Access Object

	List<ProductVO> selectList();

	ProductVO selectOne(int pno);

	int update(ProductVO pvo);

	int delete(int pno);

}
