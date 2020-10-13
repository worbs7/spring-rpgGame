package game.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard, Long>{

	Page<JpaBoard> findBySubjectLike(String text, Pageable pageable);

	Page<JpaBoard> findByContentLike(String text, Pageable pageable);

	Page<JpaBoard> findByWriterLike(String text, Pageable pageable);





}
