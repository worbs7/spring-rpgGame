package game.domain.dto;

import game.domain.entity.Verification;
import lombok.Data;

@Data
public class MailRequestDto {
	
	private String email;
	private String code;
	
	public Verification toEntity() {
		return Verification.builder()
				.code(code)
				.email(email)
				.build();
	}
}
