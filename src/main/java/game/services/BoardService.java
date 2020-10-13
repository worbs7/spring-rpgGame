package game.services;

import java.util.List;

import game.domain.dto.BoardDto;

public interface BoardService {

	void write(BoardDto dto);

	List<BoardDto> listAll();

	BoardDto detail(int no);

	void edit(BoardDto dto);

	void delete(int no);


	

}
