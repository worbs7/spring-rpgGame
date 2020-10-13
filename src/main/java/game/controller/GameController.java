package game.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import game.domain.dto.JpaDto;
import game.domain.entity.JpaBoard;
import game.services.JpaService;
/*
@Controller
public class GameController {
	
	@Autowired
	private JpaService service;
	
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	@GetMapping("board/login")
	public String login() {
		return "/board/login";
	}
	
	//리스트 가져오기
	@GetMapping("/board/list")
	public String list(Model model) {
		List<JpaDto> board = service.boardList();
		model.addAttribute("boardList", board);
		return "/board/list";
	}
	
	//단순 쓰기페이지이동
	@GetMapping("board/write")
	public String write() {
		return "/board/write";
	}
	//쓰기내용 저장
	@PostMapping("/board/write")
	public String writer(JpaDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.save(dto);
		return "redirect:/board/list";
	
	}
	//정보 보여주기
	@GetMapping("/board/{no}")
	public String detail(@PathVariable Long no , Model model) {
		
		JpaBoard board=service.detail(no);
		model.addAttribute("detail", board);
		return "redirect:/board/list";
	}
	
}
*/
