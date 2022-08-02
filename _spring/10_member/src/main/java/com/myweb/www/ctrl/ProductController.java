package com.myweb.www.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Inject
	private ProductService psv;
	
	@GetMapping("/register")
	public void register() {
		log.info(">>> ProductCtrl > register > get");
		
	}
	
	@PostMapping("/register")
	public String register(ProductVO pvo) {
		log.info(">>> register-pvo : {}", pvo);
		int isUp = psv.register(pvo);
		log.info(">>>> product register - post : {} ", isUp > 0 ? "Ok" : "FAIL" );
		return "redirect:/";
	}
	
}
