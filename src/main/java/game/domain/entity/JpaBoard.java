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

import game.domain.dto.JpaDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

	//insert 쿼리시에 null인 컬럼은 쿼리작성시 빼주세요
	//update 쿼리시에 null인 데이터는 빼주세요
	@DynamicUpdate 
	@Getter
	@NoArgsConstructor
	@EntityListeners(AuditingEntityListener.class) //날짜 자동으로 삽입
	@Table(name="jpaboard")
	@Entity
	public class JpaBoard{
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql auto increament
		private Long no;
		
		@Column(length = 500, nullable = false)
		private String subject;
		
		private int count;
		
		private String writer;
		
		@CreatedDate
		@Column(nullable = false)
		private LocalDateTime reg_date;
		
		@Column(nullable = false)
		private String user_ip;
		
		@Column(columnDefinition = "TEXT" , nullable = false)
		private String content;
		
		
		
		
		public JpaBoard countIncrement() {
			this.count++;
			return this;
		}

		@Builder
		public JpaBoard(Long no, String subject, String writer, String content , String user_ip) {
			this.no = no;
			this.subject = subject;
			this.writer = writer;
			this.content = content;
			this.user_ip = user_ip;
		}
		
		public JpaBoard update(JpaDto dto) {
			this.subject= dto.getSubject();
			this.content= dto.getContent();
			return this;
		}
}
