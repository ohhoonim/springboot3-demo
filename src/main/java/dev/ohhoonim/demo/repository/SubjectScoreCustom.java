package dev.ohhoonim.demo.repository;

import java.util.List;
import dev.ohhoonim.demo.controller.dto.SubjectScoreResponse;

public interface SubjectScoreCustom {
    List<SubjectScoreResponse> findScoresByStudent(Long studentId);
}
