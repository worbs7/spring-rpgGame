package game.domain.dto;

import game.domain.entity.JpaMember;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LogInfo {
	
	private String email;
	private String name;
	
	public LogInfo(JpaMember member) {
		this.email = member.getEmail();
		this.name = member.getName();
	}
	
	
}
