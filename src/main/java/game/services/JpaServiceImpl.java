package game.services;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import game.domain.dto.JpaDto;
import game.domain.dto.MyPageDto;
import game.domain.dto.SearchRequestDto;
import game.domain.entity.JpaBoard;
import game.domain.entity.JpaBoardRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class JpaServiceImpl implements JpaService{

	@Autowired
	private JpaBoardRepository  repository;
/*
	@Override
	public List<JpaDto> boardList() {
		List<JpaBoard> result = repository.findAll();
		//jpaBoard 에있는값을 담을 JpaDto 객체 하나를 만든다
		List<JpaDto> list = new Vector<JpaDto>();
		 //JpaBoard 바로 값을 넣어줄수없으니 디비 연결해주는 JpaDto에 담아주자 
		for(JpaBoard board:result) {
			//jpaDto 객체를 생성해서 DB값을 넣어준다
			JpaDto dto = new JpaDto(board);
			//jpaDto 객체에 값을 다시 넣어준다.
			list.add(dto);
		}
		
		return list;
	}



	@Override
	public void save(JpaDto dto) {
		repository.save(dto.toEntity());
	}


/*
	@Override
	public JpaBoard detail(Long no) {
		JpaBoard result=repository.findById(no).orElse(null);
		result.countIncrement();
		return result;
	}
*/
	/*
	public JpaBoardResponseDto fineById(Long no) {
		JpaBoard result=repository.findById(no).orElse(null);
		//DB결과가 Entity객체이므로 Dto로 데이터 변경하여 리턴하자
		JpaBoardResponseDto dto = new JpaBoardResponseDto(result);
		return dto;
	}*/
	/*
	@Transactional
	@Override
	public void edit(JpaBoardResponseDto dto) {
		JpaBoard board = repository.findById(dto.getNo()).orElse(null);
		board.update(dto.getSubject(), dto.getContent());
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}
*/
/*
	@Override
	public ModelAndView listAll(int page) {
		long start=System.nanoTime();
		//int page=0;//첫페이지
		int size=10;//페이지에 게시될 게시글수
		Sort sort=Sort.by(Direction.DESC, "no");//정렬방법,정렬요소
		
		Pageable pageable=PageRequest.of(page-1, size, sort);
		Page<JpaBoard> resultPage=repository.findAll(pageable);
		
		//PageDto<JpaBoard> pageDto=new PageDto<>(resultPage);
		MyPageDto pageDto=new MyPageDto(page, resultPage.getTotalPages());
		//log.debug("size :"+resultPage.getSize());
		
		
		//page에서 List<JpaBoard> 얻어오기
		List<JpaBoard> result=resultPage.getContent();
		//create collection<JpaBoardResponseDto>
		List<JpaDto> list=new Vector<>();
		for(JpaBoard entity : result) {
			//result에저장된 entity정보를 JpaBoardResponseDto 변경후
			JpaDto dto=new JpaDto(entity);
		
			
			//List<JpaBoardResponseDto> 에 저장
			list.add(dto);
		}
		ModelAndView mv =new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("page", pageDto);
		long end=System.nanoTime();
		return mv;
	}

	@Override
	public void write(JpaDto dto) {
		repository.save(dto.toEntity());
	}

	@Override
	public JpaBoard detail(Long no) {
		JpaBoard board = repository.findById(no).orElse(null);
		board.countIncrement();
		return board;
	}
	@Transactional
	@Override
	public void edit(JpaDto dto) {
		JpaBoard board = repository.findById(dto.getNo()).orElse(null);
		board.update(dto.getSubject(), dto.getContent());
	}
*/

	@Override
	public ModelAndView listAll(int page) {
		//int page = 0; //첫시작 페이지
		int size=10; // 페이지 나타내는 수
		Sort sort = Sort.by(Direction.DESC, "no"); // 정렬 방법 DESC , 정렬 요소를 no 통해서
		Pageable pageable = PageRequest.of(page-1, size, sort);
		
		Page<JpaBoard> resultPage = repository.findAll(pageable);
		MyPageDto pageDto = new MyPageDto(page, resultPage.getTotalPages());
		
		List<JpaBoard> result=resultPage.getContent();
		List<JpaDto> entity = new Vector<JpaDto>();
		for(JpaBoard board : result) {
			JpaDto dto = new JpaDto(board);
			entity.add(dto);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", entity);
		mv.addObject("pageInfo", pageDto);
		
		return mv;
	}

	@Override
	public void write(JpaDto dto) {
		repository.save(dto.toEntity());
		
	}

	@Transactional
	@Override
	public JpaBoard detail(Long no) {
		JpaBoard board = repository.findById(no)
				.map(e->e.countIncrement())//update
				.orElse(null);
		return board;
	}
	
	@Transactional
	@Override
	public void update(JpaDto dto) {
		repository.findById(dto.getNo()).map(e->e.update(dto)).orElse(null);
		
	}

	@Override
	public ModelAndView findSearch(int page, SearchRequestDto dto) {
		Page<JpaBoard> resultPage = null;
		int size = 10;
		Sort sort=Sort.by(Direction.DESC, "no");//정렬방법,정렬요소
		Pageable pageable=PageRequest.of(page-1, size, sort);

		String text="%"+dto.getSearchText()+"%";
		switch (dto.getSearchType()) {
		case "subject":
			resultPage = repository.findBySubjectLike(text,pageable);
			break;
		case "content":
			resultPage = repository.findByContentLike(text,pageable);
			break;
		case "writer":
			resultPage = repository.findByWriterLike(text,pageable);
			break;
		}
		List<JpaBoard> result=resultPage.getContent();
		//create collection<JpaBoardResponseDto>
		List<JpaDto> list=new Vector<>();
		for(JpaBoard entity : result) {
			//result에저장된 entity정보를 JpaBoardResponseDto 변경후
			JpaDto responsedto=new JpaDto(entity);
			//List<JpaBoardResponseDto> 에 저장
			list.add(responsedto);
		}
		MyPageDto pageDto=new MyPageDto(page, resultPage.getTotalPages()); //페이지정보
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("pageInfo", pageDto);
		
		return mv;
	}

	

	
	






	
}
