package com.myweb.www.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	
	// 스프링 프레임워크는 실행할 때 @Component로 등록된 모든 클래스를 사전에 인스턴스로 만든다 
	// @Component로 인스턴스된 클래스들은 @Inject, @autowired를 통해 사용할 수 있다
	// DispatcherServlet은 request가 발생하면 부석하기 위해 @requestMapping을 호출한다
	// @requestMapping은 uri값의 패턴에 따라 각 메서드에게 실행주문을 전달한다
	
	@Inject
	private MemberService msv;
	@Inject
	private FileHandler fhd;	
	private final BCryptPasswordEncoder bcpEncoder;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void register() {
		// request의 uri 패턴이 같다면 void로 선언 후 그대로 viewResolver에게 전달
		// 해당 uri와 같은 위치의 jsp로 forward된다
		log.info(">>> MemberController > register - GET");
		
	}
	
	@PostMapping("/register")
	public String register(MemberVO mvo, @RequestParam(name="fileAttached", required=false) MultipartFile files) {
		FileVO file=null;
		if(files.getSize() > 0) {
			file = fhd.getFile(files);
			
		}
		mvo.setPwd(bcpEncoder.encode(mvo.getPwd()));
		int isUp = msv.register(new MemberDTO(mvo, file));
		
		return "redirect:/";
	}
	
	@GetMapping("/list") //Springframework 4.3부터 지원
	public void list(Model model, ModelAndView mav, PagingVO pgvo) {
		log.info(">>> member list - get");
		List<MemberVO> list = msv.list(pgvo);
		model.addAttribute("list", list);
		int totalCount = msv.getTotalCount(pgvo);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
		
	}
	@GetMapping({"/detail", "/modify"})
	public void detail(Model model, @RequestParam("email") String email,
			@ModelAttribute("pgvo") PagingVO pgvo) {
		log.info(">>> member detail - get");
		MemberDTO mdto = msv.detail(email);
		model.addAttribute("mdto", mdto);
		
	}
	@PostMapping("/modifiy")
	public String modifiy(MemberVO mvo, RedirectAttributes rttr, PagingVO pgvo) {
		msv.modifiy(mvo);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/member/detail?email="+mvo.getEmail();
		
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("email") String email,RedirectAttributes rttr ,PagingVO pgvo) {
		int isUp = msv.remove(email);
		log.info(">>> memberctrl > remove : {}", isUp > 0 ? "OK" : "FAIL");
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		return "redirect:/member/list";
	}
	@GetMapping("/login")
	public void login() {
		log.info(">>> member login - get ");
	}
	@PostMapping("/login")
	public String login(RedirectAttributes rttr,HttpServletRequest req) {		/*
		 * int lastLog = msv.modlog(mvo.getEmail()); MemberVO sesMvo = msv.login(mvo);
		 * log.info(">>> member login > lastLogin update : {}", lastLog > 0 ? "OK" :
		 * "FAIL"); if(sesMvo != null) { log.info(">>> member login - Ok");
		 * ses.setAttribute("ses", sesMvo); MemberDTO mdto = msv.detail(mvo.getEmail());
		 * ses.setAttribute("mdto", mdto); ses.setMaxInactiveInterval(600); // 10 Min
		 * rttr.addFlashAttribute("isLogin", 1); return "redirect:/"; } else { return
		 * "redirect:/member/login"; }
		 */
		
		rttr.addFlashAttribute("email",req.getAttribute("email"));
		rttr.addFlashAttribute("errMsg",req.getAttribute("errMsg"));
		return "redirect:/member/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession ses, RedirectAttributes rttr) {
		ses.removeAttribute("ses"); // ses 라는 이름을 갖는 세션 객체를 삭제
		ses.invalidate();
		rttr.addFlashAttribute("isLogout", 1);
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping(value = "/dupleCheck", consumes = "application/json",
				 produces = {MediaType.TEXT_PLAIN_VALUE})
	public String dupleCheck(@RequestBody HashMap<String, String> map) {
		// ajax > email : value
		log.info(">>> {}", map.get("email"));
		int isExist = msv.dupleCheck(map.get("email"));
		
		return isExist > 0 ? "1" : "0";
	}
	
}
