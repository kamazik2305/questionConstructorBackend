package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private long id;

    @Column(name = "question_text")
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "id_question_type", nullable = false)
    private QuestionType questionType;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerVersion> answerVersions;

    @OneToOne(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Description description;

    public Question(String questionText, QuestionType questionType, List<AnswerVersion> answerVersions) {
        this.questionText = questionText;
        this.questionType = questionType;
        this.answerVersions = answerVersions;
    }
}
