package game.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Verification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vno;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String code;

	@Builder
	public Verification(String email, String code) {
		this.email = email;
		this.code = code;
	}
	
	
}
