package game.domain.dto;

import java.time.LocalDateTime;

import game.domain.entity.JpaBoard;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JpaBoardResponseDto {
	
	private Long no;
	private String subject; 
	private int count;
	private String writer;
	private LocalDateTime reg_date;
	private String user_ip;
	private String content;
	
	
	public JpaBoard toEtity() {
		return JpaBoard.builder()
				.content(content)
				.writer(writer)
				.subject(subject)
				.user_ip(user_ip)
				.build();
	}


	public JpaBoardResponseDto(JpaBoard board) {
		this.no = board.getNo();
		this.subject = board.getSubject();
		this.count = board.getCount();
		this.writer = board.getWriter();
		this.reg_date = board.getReg_date();
		this.user_ip = board.getUser_ip();
		this.content = board.getContent();
	}
	
	
	
}
