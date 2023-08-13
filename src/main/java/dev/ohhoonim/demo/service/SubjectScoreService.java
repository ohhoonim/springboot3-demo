package dev.ohhoonim.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.ohhoonim.demo.controller.dto.SubjectScoreResponse;
import dev.ohhoonim.demo.repository.primary.SubjectScoreRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectScoreService {

    private final SubjectScoreRepository repository;
    
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {
        return repository.findScoresByStudent(studentId);
    }

}
