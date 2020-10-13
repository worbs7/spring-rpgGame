package game.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.MemberDto;
import game.services.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원가입 페이지 이동
	@GetMapping("/member/join") 
	public String join() {
		return "/sign/join";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "/sign/login";
	}
	
	
	@PostMapping("/sign/join")
	public ModelAndView join(MemberDto dto) {
		ModelAndView mv = service.join(dto);
		mv.setViewName("/sign/login");
		return mv;
	}
	 

	@PostMapping("/user/login")
	public ModelAndView login(MemberDto dto) {
		
		ModelAndView mv =service.login(dto);
		
		
		return mv;
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("logInfo");
		return "redirect:/";
	}
	
}

