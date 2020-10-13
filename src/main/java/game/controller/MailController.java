package game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import game.domain.dto.MailRequestDto;
import game.services.MailService;

@Controller
public class MailController {
	
	@Autowired
	private MailService service;
	
	@ResponseBody
	@PostMapping("/mail")
	public void mail(String email) {
		service.mailSend(email);
	}
	
	@ResponseBody
	@PostMapping("/mail/check")
	public String mailcheck(MailRequestDto dto) {
		return service.mailCheck(dto);
		
	}
}
