package game.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import game.domain.dto.BoardDto;

@Mapper
public interface BoardMapper {

	void write(BoardDto dto);

	List<BoardDto> listAll();

	BoardDto detail(int no);

	void edit(BoardDto dto);

	void delete(int no);


	


}
