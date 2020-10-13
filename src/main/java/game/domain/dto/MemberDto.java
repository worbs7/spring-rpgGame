package game.domain.dto;

import game.domain.entity.JpaMember;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberDto {

	private String email;
	private String pw;
	
	
	public JpaMember toEntity() {
		return JpaMember.builder()
				.email(email)
				.pw(pw)
				.name("닉네임")
				.build();
	}
	

	
	
}
