package ru.questionConstructorBackend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    @NotNull
    private long id;
    @NotEmpty
    private String questionText;
    @NotNull
    private long idQuestionType;

    private List<AnswerVersionDto> answerVersions;

}
