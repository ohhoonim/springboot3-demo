package dev.ohhoonim.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ohhoonim.demo.controller.dto.SubjectScoreResponse;
import dev.ohhoonim.demo.service.SubjectScoreService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectScoreController {
   
    private final SubjectScoreService service;

    @GetMapping(value="/score/{studentId}")
    public ResponseEntity<List<SubjectScoreResponse>> getScoresByStudent (@PathVariable Long studentId) {
        List<SubjectScoreResponse> subjectSocreList = service.findScoresByStudent(studentId);
        return ResponseEntity.ok(subjectSocreList); 
    }
    
}
