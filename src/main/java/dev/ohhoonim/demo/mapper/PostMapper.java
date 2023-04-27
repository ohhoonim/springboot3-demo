package dev.ohhoonim.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import dev.ohhoonim.demo.model.Post;

@Mapper
public interface PostMapper {
   public List<Post> listPost(); 
}
