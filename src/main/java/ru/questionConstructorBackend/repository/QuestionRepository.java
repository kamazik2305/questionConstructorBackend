package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.questionConstructorBackend.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByQuestionTextContains(@Param("searchString") String searchString);
}
