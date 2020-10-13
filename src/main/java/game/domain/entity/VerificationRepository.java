package game.domain.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, Long>{

	Optional<Verification> findByEmailAndCode(String email, String code);


}
