package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "selected_answer")
@Getter
@Setter
@NoArgsConstructor
public class SelectedAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_selected_answer")
    private long id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "verity")
    private Boolean verity;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id_test_result")
    private TestResult testResult;


}
