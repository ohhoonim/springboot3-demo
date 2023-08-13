package dev.ohhoonim.demo.repository.primary;

import java.util.List;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.ohhoonim.demo.controller.dto.SubjectScoreResponse;
import dev.ohhoonim.demo.model.primary.QScore;
import dev.ohhoonim.demo.model.primary.QStudent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubjectScoreCustomImpl implements SubjectScoreCustom {

    private final JPAQueryFactory queryFactory;

    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {

        QStudent st = QStudent.student;
        QScore sc = QScore.score1;
        
        JPAQuery<Tuple> query = queryFactory.select(
                st.studentId,
                st.name, 
                st.age,
                sc.subject,
                sc.score
        ).from(st) 
        .join(sc).on(st.studentId.eq(sc.studentId))
        .where(st.studentId.eq(studentId))
        .orderBy(st.studentId.desc());

        // return query.fetch().stream().map(t -> SubjectScoreResponse.builder().build()).toList();
        return query.fetchJoin().fetch().stream().map(tupple -> 
            SubjectScoreResponse.builder()
                .studentId(tupple.get(st.studentId))
                .name(tupple.get(st.name))
                .age(tupple.get(st.age))
                .subject(tupple.get(sc.subject))
                .score(tupple.get(sc.score))
            .build()
        ).toList();
    }
}
