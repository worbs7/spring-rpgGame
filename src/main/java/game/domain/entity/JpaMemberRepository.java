package game.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<JpaMember, Long>{

	Optional<JpaMember> findByEmail(String email);

	Optional<JpaMember> findByEmailAndPw(String email, String pw);


	
	

}
