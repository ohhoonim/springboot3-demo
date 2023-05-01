package dev.ohhoonim.demo.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findByTitleContainsOrderByTitleDesc(String title);

}
