package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "true_answer")
@Getter
@Setter
@NoArgsConstructor
public class TrueAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_true_answer")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_answer_version")
    private AnswerVersion answerVersion;

    public TrueAnswer(Question question, AnswerVersion answerVersion) {
        this.question = question;
        this.answerVersion = answerVersion;
    }
}
