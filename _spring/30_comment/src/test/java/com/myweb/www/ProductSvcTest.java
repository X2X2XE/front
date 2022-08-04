package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductSvcTest {
	private static Logger log = LoggerFactory.getLogger(ProductSvcTest.class);
	
	@Inject
	private ProductService psv;
	
	@Test
	public void register_test() throws Exception{
		int isUp = psv.register(new ProductVO("cate122", 
				"P-A", 100, "tester200@tester.com","DESC-A", "TESddsTERS"));
		log.info("regisere : {}", isUp > 0 ? "Ok": "fail");
		
		
	}
}
