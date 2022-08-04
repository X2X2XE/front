package com.myweb.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String register(ProductVO pvo, RedirectAttributes rttr) {
		
		int isUp = psv.register(pvo);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info(">>> product list - get");
		List<ProductVO> list = psv.getList();
		model.addAttribute("list", list);
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno") long pno, Model model) {
		
		ProductVO pvo = psv.getDetail(pno);
		model.addAttribute("pvo", pvo);
	}
			
	@PostMapping("/modify")
	public String modifiy(ProductVO pvo) {
		log.info(">>> product mod - post ");
		int isUp = psv.modifiy(pvo);
		log.info(">> product modi : {}", isUp >0 ? "OK" : "Fail");
		return "redirect:/product/detail?pno=" + pvo.getPno();
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr) {
		int isUp = psv.remove(pno);
		log.info(">>> product > remove  {}", isUp > 0 ? "OK" : "Fail");
		
		return "redirect:/";
	}
	
	
}
