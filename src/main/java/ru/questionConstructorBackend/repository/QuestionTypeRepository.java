package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.questionConstructorBackend.entity.QuestionType;


public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {

}
