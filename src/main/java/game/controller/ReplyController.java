package game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import game.domain.dto.ReplyDto;
import game.domain.dto.ReplyResponseDto;
import game.services.ReplyService;


@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@ResponseBody
	@GetMapping("/reply/delete/{rno}")
	public String delete(@PathVariable long rno) {
		service.delete(rno);
		return null;
	}
	
	
	@ResponseBody
	@PostMapping("/reply/reg")
	public String reg(ReplyDto dto) {
		service.reg(dto);
		return "등록완료";
	}
	
	
	@PostMapping("/reply/list")
	public String list(long bno, Model model) {
		List<ReplyResponseDto> list=service.findAllByB_no(bno);
		model.addAttribute("replylist", list);
		return "/jpa/replyList";
	}
	
	@ResponseBody
	@PostMapping("/reply/update")
	public void update(long rno , String content) {
		service.update(rno,content);
	}
	
	
	
}
