package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.questionConstructorBackend.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
