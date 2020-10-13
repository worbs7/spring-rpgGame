package game.domain.dto;

import java.time.LocalDateTime;

import game.domain.entity.JpaBoard;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JpaDto {
	
	private Long no;
	private String writer;
	private String subject;
	private String content;
	private String user_ip;
	private int count; 
	private LocalDateTime reg_date;
	
	public JpaBoard toEntity() {
		return JpaBoard.builder().content(content).subject(subject).user_ip(user_ip).writer(writer).build();
	}

	public JpaDto(JpaBoard bo) {
		this.no = bo.getNo();
		this.writer = bo.getWriter();
		this.subject = bo.getSubject();
		this.content = bo.getContent();
		this.user_ip = bo.getUser_ip();
		this.count = bo.getCount();
		this.reg_date = bo.getReg_date();
	}
	
	
}
