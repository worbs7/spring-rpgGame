package game.services;

import java.util.List;

import game.domain.dto.ReplyDto;
import game.domain.dto.ReplyResponseDto;

public interface ReplyService {

	void reg(ReplyDto dto);

	List<ReplyResponseDto> findAllByB_no(long bno);

	void delete(long rno);

	void update(long rno, String content);


}
