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

    public List<Post> postList(int size, int page) {
        // 1. 검색 : example 사용
        // Example<Post> example = Example.of(Post.builder().title("title").build(),
        //         ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING));
        // return postRepository.findAll(example,
        //         Sort.by(Order.desc("title")));

        // 2. 검색 : jpql (query creation) 사용 
        // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
        // jpql
        // return postRepository.findByTitleContainingOrderByTitleDesc("title");

        // 3. paging
        return postRepository.findAll(Pageable.ofSize(size).withPage(page)).toList();

    }
}
