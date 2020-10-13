package game.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.BoardDto;
import game.services.BoardService;


@Controller
public class MybaitsController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list") //서버에서 요청한주소
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/board/list");
		List<BoardDto> list = service.listAll();
		mv.addObject("list", list); 
		return mv;  //그페이지로 이동시켜주는 경로야
	}
	
	@GetMapping("/board/write") //서버에 요청
	public String write() {
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(BoardDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getLocalAddr());
		service.write(dto);
		System.out.println(dto);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/{no}")
	public ModelAndView detail(@PathVariable int no, ModelAndView mv) {
		mv.setViewName("/board/detail");
		BoardDto dto = service.detail(no);
		mv.addObject("detail", dto);
		return mv;
	}
	
	@PostMapping("/board/edit")
	public String edit(BoardDto dto) {
		service.edit(dto);
		
		return "redirect:/board/list";
			
		}
	
	@GetMapping("/board/delete/{no}")
	public String delete(@PathVariable int no) {
		service.delete(no);
		return "redirect:/board/list";
	}
}

