package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.questionConstructorBackend.entity.TrueAnswer;

public interface TrueAnswerRepository extends JpaRepository<TrueAnswer, Long> {
}
