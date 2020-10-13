package game.services;

import game.domain.dto.MailRequestDto;

public interface MailService {

	void mailSend(String email);

	String mailCheck(MailRequestDto dto);
	
}
