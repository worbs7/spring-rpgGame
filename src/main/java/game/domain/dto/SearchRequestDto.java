package game.domain.dto;

import lombok.Data;

@Data
public class SearchRequestDto {
	private String searchType;
	private String searchText;
}
