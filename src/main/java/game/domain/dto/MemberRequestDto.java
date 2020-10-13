package game.domain.dto;

import game.domain.entity.JpaMember;
import lombok.Data;

@Data
public class MemberRequestDto {
	
	private Long no;
	private String email;
	private String pw;
	private String name;
	
	public MemberRequestDto(JpaMember m) {
		this.no = m.getNo();
		this.email =m.getEmail();
		this.pw = m.getPw();
		this.name = m.getName();
	}
	
	
}
