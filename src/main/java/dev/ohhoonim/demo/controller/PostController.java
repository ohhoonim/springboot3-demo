package dev.ohhoonim.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ohhoonim.demo.model.Post;

@RestController
@RequestMapping("/posts")
public class PostController {
    
    @GetMapping("/list")
    public List<Post> postList() {
        return List.of(
            new Post("1","title1", "contents1", "", LocalDateTime.now()),
            new Post("2","title2", "contents2", "", LocalDateTime.now()),
            new Post("3","title3", "contents3", "", LocalDateTime.now())
        );
    }

    @GetMapping("/{postId}")
    public Post postDetail(@PathVariable String postId){
        return new Post("1","title1", "contents1", "", LocalDateTime.now());
    }

    
}
