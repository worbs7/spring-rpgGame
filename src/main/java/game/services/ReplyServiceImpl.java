package game.services;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import game.domain.dto.ReplyDto;
import game.domain.dto.ReplyResponseDto;
import game.domain.entity.Reply;
import game.domain.entity.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyRepository repository ;

	@Override
	public void reg(ReplyDto dto) {
		repository.save(dto.toEntity());
		
	}

	@Override
	public List<ReplyResponseDto> findAllByB_no(long bno) {
		List<Reply> result= repository.findAllByBNo(bno);
		List<ReplyResponseDto> list = new Vector<ReplyResponseDto>();
		for(Reply reply:result) {
			ReplyResponseDto dto = new ReplyResponseDto(reply);
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public void delete(long rno) {
		repository.deleteById(rno);
		
	}
	
	@Transactional
	@Override
	public void update(long rno, String content) {
		//먼저 글이 존재하는지 확인작업
		Reply result = repository.findById(rno).map(e->e.update(content)).orElse(null);
	}

		
	
	
	
}
