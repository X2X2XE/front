package com.misson.www.ctrl;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.misson.www.domain.UserVO;
import com.misson.www.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserCtrl {
	@Inject
	private UserService usv;
	
	@GetMapping("/register")
	public void register() {
		
	}
	@PostMapping("/register")
	public String register(UserVO uvo) {
		usv.register(uvo);
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping(value = "/dupleCheck", consumes = "application/json",
				 produces = {MediaType.TEXT_PLAIN_VALUE})
	public String dupleCheck(@RequestBody HashMap<String, String> map) {
		int isExist = usv.dupleCheck(map.get("email"));
		return isExist > 0 ? "1" : "0";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	@PostMapping("/login")
	public String login(UserVO uvo, HttpSession ses, RedirectAttributes rttr) {
		UserVO login = usv.login(uvo);
		if(login != null) {
			ses.setAttribute("ses", login);
			ses.setMaxInactiveInterval(600);
			rttr.addFlashAttribute("isLogin",1);
			return "redirect:/";
		} else {
			return "redirect:/user/login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession ses, RedirectAttributes rttr) {
		ses.removeAttribute("ses");
		ses.invalidate();
		rttr.addFlashAttribute("isLogout", 1);
		return "redirect:/";
	}
}
