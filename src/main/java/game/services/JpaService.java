package game.services;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.JpaDto;
import game.domain.dto.SearchRequestDto;
import game.domain.entity.JpaBoard;

public interface JpaService {

	ModelAndView listAll(int page);
/*
	void write(JpaDto dto);


	JpaBoard detail(Long no);

	void edit(JpaDto dto);

	ModelAndView listAll(int page);
*/

	void write(JpaDto dto);

	JpaBoard detail(Long no);

	void update(JpaDto dto);

	ModelAndView findSearch(int page, SearchRequestDto dto);





	





}
