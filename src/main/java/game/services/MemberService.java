package game.services;

import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.MemberDto;
import game.domain.dto.MemberRequestDto;

public interface MemberService{

	ModelAndView join(MemberDto dto);

	ModelAndView login(MemberDto dto);






}
