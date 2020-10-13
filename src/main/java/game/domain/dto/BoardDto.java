package game.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	private int no;  // 번호
	private String subject; //제목
	private int count;  //조회수
	private String writer ; //작성자
	private LocalDateTime reg_date; //날짜
	private String user_ip; //아이피
	private String content ;  //내용
	
	
	
}
