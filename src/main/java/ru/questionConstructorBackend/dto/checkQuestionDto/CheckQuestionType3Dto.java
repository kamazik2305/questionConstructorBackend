package ru.questionConstructorBackend.dto.checkQuestionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.questionConstructorBackend.dto.AnswerVersionDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckQuestionType3Dto {

    @NotEmpty
    private String questionText;
    @NotNull
    private List<AnswerVersionDto> answers;
    @NotNull
    private List<AnswerVersionDto> selectedAnswers;
}
