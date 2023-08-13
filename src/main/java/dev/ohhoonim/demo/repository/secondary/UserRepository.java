package dev.ohhoonim.demo.repository.secondary;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.secondary.User;

public interface UserRepository extends JpaRepository<User, Long> {
   public Optional<User> findByEmail(String email); 
}
