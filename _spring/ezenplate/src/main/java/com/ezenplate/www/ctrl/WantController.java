package com.ezenplate.www.ctrl;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezenplate.www.domain.PagingVO;
import com.ezenplate.www.handler.PagingHandler;
import com.ezenplate.www.service.WantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/want/*")
public class WantController {
	@Inject
	private WantService wsv;
	
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo, @RequestParam("mno")long mno) {
		log.info(">>> WantController list - GET");
		model.addAttribute("list", wsv.getList(pgvo, mno));
		int totalCount = wsv.getTotalCount(pgvo, mno);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("sno")long sno, @RequestParam("mno")long mno, RedirectAttributes rttr, PagingVO pgvo) {
		int isUp = wsv.remove(sno, mno);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		log.info(">>> WantController remove - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/want/list?mno=" + mno;
	}
}
