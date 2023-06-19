package ru.questionConstructorBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "description")
@Data
@NoArgsConstructor
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_description")
    private long id;

    @Column(name = "description_text")
    private String descriptionText;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_question")
    private Question question;

}
