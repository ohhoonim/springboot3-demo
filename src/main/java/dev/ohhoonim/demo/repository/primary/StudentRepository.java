package dev.ohhoonim.demo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.primary.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
