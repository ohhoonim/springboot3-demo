package dev.ohhoonim.demo.repository.secondary;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.secondary.Tokens;

public interface TokenRepository extends JpaRepository<Tokens, Long>, TokenRepositoryCustom {
    Optional<Tokens> findByToken(String token);
   
}
