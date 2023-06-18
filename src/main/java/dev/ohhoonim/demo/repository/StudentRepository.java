package dev.ohhoonim.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.ohhoonim.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
