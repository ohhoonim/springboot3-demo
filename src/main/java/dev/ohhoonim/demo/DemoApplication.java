package dev.ohhoonim.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dev.ohhoonim.demo.model.Post;
import dev.ohhoonim.demo.repository.PostRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

    DemoApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private final PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Post> postList = List.of(
			new Post(UUID.randomUUID(),"title1", "contents1", "", LocalDateTime.now()),
			new Post(UUID.randomUUID(),"title2", "contents2", "", LocalDateTime.now()),
			new Post(UUID.randomUUID(),"title3", "contents3", "", LocalDateTime.now())
			);
		for (Post p : postList) {
			postRepository.save(p);
		}
	}

}
