package dev.ohhoonim.demo.service;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import dev.ohhoonim.demo.model.Post;
import dev.ohhoonim.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> postList() {
        return postRepository.findAll();

    }
}
