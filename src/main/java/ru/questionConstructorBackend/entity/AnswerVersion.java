package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answer_version")
@Getter
@Setter
@NoArgsConstructor
public class AnswerVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_answer_version")
    private long id;

    @Column(name = "answer_text")
    private String answerText;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @OneToOne(mappedBy = "answerVersion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private TrueAnswer trueAnswer;

    public AnswerVersion(String answerText, Question question, TrueAnswer trueAnswer) {
        this.answerText = answerText;
        this.question = question;
        this.trueAnswer = trueAnswer;
    }
}
