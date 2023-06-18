package dev.ohhoonim.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.Score;

public interface SubjectScoreRepository extends JpaRepository<Score, Long>, SubjectScoreCustom{

    

    

}
