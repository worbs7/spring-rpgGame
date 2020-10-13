package game.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
	

	@Getter
	@NoArgsConstructor
	@EntityListeners(AuditingEntityListener.class)
	@Table(name="jpa_member")
	@Entity
	public class JpaMember{
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long no;
		
		@Column(nullable = false)
		private String email;
		
		@Column(nullable = false) //필수항목일때 사용 
		private String pw;
		
		@Column(nullable = false) //필수일때 사용
		String name;
		
		@Column(nullable = false)
		@CreatedDate
		private LocalDateTime createdate;
		
		@Builder
		public JpaMember(String email, String pw, String name) {
			super();
			this.email = email;
			this.pw = pw;
			this.name = name;
		}
		
	
		
		
		
		
		
}
