package ru.questionConstructorBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.questionConstructorBackend.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
