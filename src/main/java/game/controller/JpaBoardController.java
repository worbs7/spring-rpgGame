package game.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.JpaDto;
import game.domain.dto.SearchRequestDto;
import game.domain.entity.JpaBoard;
import game.services.JpaService;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class JpaBoardController {
	
	@Autowired
	private JpaService service;
	/*
	@GetMapping("/jpa/list")
	public String list(Model model) {
		List<JpaDto> dto = service.listAll();
		model.addAttribute("list", dto);
		return "/jpa/list";
	}
	@GetMapping("/jpa/write")
	public String write() {
	
		return "jpa/write";
	}
	
	@PostMapping("/jpa/write")
	public String write(JpaDto dto , HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.write(dto);
		
		return "redirect:/jpa/list";
	}
	
	@GetMapping("/jpa/{no}")
	public String detail(@PathVariable Long no,Model model) {
		
		JpaBoard dto = service.detail(no);
		model.addAttribute("detail",dto);
		return "/jpa/detail";
	}
	
	
	@PostMapping("/jpa/edit")
	public String edit(JpaDto dto) {
		 service.edit(dto);
		return "redirect:/jpa/list";
		
	}
	*/
	/*
	@GetMapping("/jpa/list/{page}")
	public ModelAndView listAll(@PathVariable int page) {
		//페이지에 갖고갈 데이터 갖고작업을
		//누구한테 시킬까요?
		ModelAndView mv=service.listAll(page);
		//model.addAttribute("jpaList", list);
		mv.setViewName("/jpa/list");//이동할 페이지 정보
		return mv;
	}
	
	@GetMapping("/jpa/write")
	public String write() {
		
		
		return "/jpa/write";
	}
	
	@PostMapping("/jpa/write")
	public String write(JpaDto dto, HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.write(dto);
		log.debug(dto);
		return "redirect:/jpa/list/1";
	}
	
	@GetMapping("/jpa/detail/{no}")
	public ModelAndView detail(@PathVariable Long no) {
		JpaBoard board=service.detail(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", board);
		mv.setViewName("/jpa/detail");
		return mv;
	}
	
	@PostMapping("/jpa/edit")
	public String edit(JpaDto dto) {
		service.edit(dto);
		return "redirect:/jpa/list";
	}
	*/
	
	@GetMapping("/jpa/list/{page}")
	public ModelAndView listAll(@PathVariable int page,SearchRequestDto dto) {
		ModelAndView mv = null;
		if(dto.getSearchText()==null) {
			mv=service.listAll(page);
		}else {
			mv=service.findSearch(page,dto);
		}
			
		mv.setViewName("/jpa/list");
		return mv;
	}
	
	@GetMapping("/jpa/write")
	public String write() {
		return "/jpa/write";
	}
	
	@PostMapping("/jpa/write")
	public String write(JpaDto dto , HttpServletRequest request) {
		dto.setUser_ip(request.getRemoteAddr());
		service.write(dto);
		return "redirect:/jpa/list/1";
	}
	
	@GetMapping("/jpa/detail/{no}")
	public ModelAndView detail(@PathVariable Long no) {
		ModelAndView mv = new ModelAndView();
		JpaBoard board = service.detail(no);
		mv.addObject("detail", board);
		mv.setViewName("/jpa/detail");
		return mv;
	}
	
	@PostMapping("/jpa/edit")
	public String edit(JpaDto dto) {
		service.update(dto);
		return "redirect:/jpa/list/1";
	}
	
	
	
	
}

