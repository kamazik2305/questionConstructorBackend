package ru.questionConstructorBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckQuestionDto {

    @NotNull
    private long id;
    @NotEmpty
    private String questionText;
    @NotNull
    private long idQuestionType;
    @NotNull
    private List<AnswerVersionDto> trueAnswers;
    @NotNull
    private List<AnswerVersionDto> selectedAnswers;
}
