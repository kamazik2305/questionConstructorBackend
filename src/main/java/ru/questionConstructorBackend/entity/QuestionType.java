package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "question_type")
@Getter
@Setter
@NoArgsConstructor
public class QuestionType {

    @Id
    @Column(name = "id_question_type")
    private long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "questionType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    public QuestionType(String typeName, List<Question> questions) {
        this.typeName = typeName;
        this.questions = questions;
    }
}
