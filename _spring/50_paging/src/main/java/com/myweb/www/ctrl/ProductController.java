package com.myweb.www.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	
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
	public void list(Model model, PagingVO pgvo) {
		log.info(">>> product list - get");
		List<ProductVO> list = psv.getList(pgvo);
		model.addAttribute("list", list);
		int totalCount = psv.getTotalCount();
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno") long pno, Model model,
			@ModelAttribute("pgvo") PagingVO pgvo) {
		
		ProductVO pvo = psv.getDetail(pno);
		model.addAttribute("pvo", pvo);
		
	}
			
	@PostMapping("/modify")
	public String modifiy(ProductVO pvo, RedirectAttributes rttr,PagingVO pgvo) {
		log.info(">>> product mod - post ");
		int isUp = psv.modifiy(pvo);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		log.info(">> product modi : {}", isUp >0 ? "OK" : "Fail");
		
		return "redirect:/product/detail?pno=" + pvo.getPno();
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = psv.remove(pno);
		log.info(">>> product > remove  {}", isUp > 0 ? "OK" : "Fail");
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/product/list";
	}
	
	
}