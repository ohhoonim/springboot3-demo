package dev.ohhoonim.demo.repository.primary;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.primary.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
