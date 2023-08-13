package dev.ohhoonim.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ohhoonim.demo.model.primary.Post;
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

    @GetMapping("/errorList")
    public void errorList() throws Exception {
        throw new Exception("임의로 exception 발생");
    } 
    
}
