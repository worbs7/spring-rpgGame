package game.domain.dto;

import game.domain.entity.Reply;
import lombok.Data;

@Data
public class ReplyDto {
	String content;
	String writer;
	Long bno;
	
	public Reply toEntity() {
		return Reply.builder().content(content).writer(writer).bno(bno).build();
	}
	
}
