package dev.ohhoonim.demo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.primary.Score;

public interface SubjectScoreRepository extends JpaRepository<Score, Long>, SubjectScoreCustom{

    

    

}
