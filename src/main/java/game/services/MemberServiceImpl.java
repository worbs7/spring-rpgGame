package game.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.LogInfo;
import game.domain.dto.MemberDto;
import game.domain.dto.MemberRequestDto;
import game.domain.entity.JpaMember;
import game.domain.entity.JpaMemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private JpaMemberRepository repository;

	@Override
	public ModelAndView join(MemberDto dto) {
		Optional<JpaMember> op = repository.findByEmail(dto.getEmail());
		ModelAndView mv = new ModelAndView();
		if(op.isPresent()) { //만약에 op에 객체가 존재한다면
			mv.addObject("log_msg", "이미 아이디가 존재합니다.");
		}else {
			repository.save(dto.toEntity());
			mv.addObject("welcome_msg", "회원가입을 축하합니다.");
		}
		return mv;
		
	}

	
	@Autowired
	HttpSession session;
	
	ModelAndView mv = new ModelAndView();
	/*
	@Override
	public ModelAndView login(MemberDto dto) {
		Optional<JpaMember> op = repository.findByEmailAndPw(dto.getEmail(),dto.getPw());
		if(op.isPresent()) { //아이디가 존재하면
			//존재
			//JpaMember result=op.get();
			//세션에 로그인정보 등록
			session.setAttribute("logInfo", new LogInfo(op.get()));
			//페이지이동 index페이지로.
			mv.setViewName("redirect:/");
			
		}else {
			//비회원
			//메세지를 날려주자
			//페이지이동 로그인 다시 입력할 수 있도록 
			
			mv.addObject("log_msg" ,"id 혹은 비밀번호가 틀립니다." );
			mv.setViewName("/sign/login");
		}
		
	
		return mv;
	}
	
	*/

	@Override
	public ModelAndView login(MemberDto dto) {
		Optional<JpaMember> op = repository.findByEmailAndPw(dto.getEmail(), dto.getPw());
		if(op.isPresent()) {
			session.setAttribute("logInfo", new LogInfo(op.get()));
			mv.setViewName("redirect:/");
		}else {
			mv.addObject("log_msg", "id혹은 비밀번호가 틀립니다.");
			mv.setViewName("/sign/login");
		}
		
		return mv;
		
	}
	/*
	JpaMember member = repository.findByEmailAndPw(dto.getEmail(),dto.getPw()).orElse(null);//null 일경우 로그인처리를 할것이냐.
	if(member==null) {//존재하면
		//회원존재
	}else {
		//비회원
	}
	*/
	
	
	
}
