package dev.ohhoonim.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.ohhoonim.demo.mapper.PostMapper;
import dev.ohhoonim.demo.model.Post;
import dev.ohhoonim.demo.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    @GetMapping("/list")
    public List<Post> postList() {
        return postService.postList();
    }

    
    
}
