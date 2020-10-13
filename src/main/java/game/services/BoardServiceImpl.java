package game.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import game.domain.dto.BoardDto;
import game.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper mapper ;

	@Override
	public void write(BoardDto dto) {
		
		mapper.write(dto);
		
	}

	@Override
	public List<BoardDto> listAll() {
		
		return mapper.listAll();
	}

	@Override
	public BoardDto detail(int no) {
		
		return mapper.detail(no);
	}

	@Override
	public void edit(BoardDto dto) {
		mapper.edit(dto);
		
	}

	@Override
	public void delete(int no) {
		mapper.delete(no);
		
	}

	

	

	
	
}
