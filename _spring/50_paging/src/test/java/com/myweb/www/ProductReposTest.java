package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductReposTest {
	private static Logger log = LoggerFactory.getLogger(ProductReposTest.class);
	
	@Inject
	private ProductDAO pdao;
	
	@Test
	public void insert_test() throws Exception{
		int isUp=1;
		for(int i =0; i< 100; i++) {
			isUp *= pdao.insert(new ProductVO("cate" +((int)i/10), "P-A"+(i), 100+i, "tester"+(i)+"@tester.com", "DESC-A"+i, "TESTERS"));	
		}
		
		log.info(">>> insert_test > {}", isUp> 0 ? "OK" : "Fail");
	}
	
	@Test
	public void selectProductListTest() throws Exception{
		for (ProductVO pvo : pdao.selectList()) {
			log.info("{}", pvo);
		}
	}
	
	@Test
	public void selectProductTest() throws Exception{
		log.info("{}", pdao.selectOne(21));
	}
	
	@Test
	public void update_test() throws Exception{
		int isUp = pdao.update(new ProductVO(82L ,"cate1", 
				"P-A",100, "DESC-A", "TESTERS"));	
	}
	
	@Test
	public void delete_Test() throws Exception{
		int isUp = pdao.delete(88L);
		log.info(">>> del : {}", isUp > 0 ? "OK" : "Fail");
	}
}
