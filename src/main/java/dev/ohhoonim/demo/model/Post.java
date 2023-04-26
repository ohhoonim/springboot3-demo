package dev.ohhoonim.demo.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private String postId;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdDateTime;
}
