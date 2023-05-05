package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.questionConstructorBackend.entity.AnswerVersion;

public interface AnswerVersionRepository extends JpaRepository<AnswerVersion, Long> {
}
