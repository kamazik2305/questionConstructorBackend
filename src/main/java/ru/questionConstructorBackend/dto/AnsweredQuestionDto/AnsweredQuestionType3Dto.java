package ru.questionConstructorBackend.dto.AnsweredQuestionDto;

import lombok.*;
import ru.questionConstructorBackend.dto.AnswerVersionDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnsweredQuestionType3Dto {

    @NotEmpty
    private String questionText;
    @NotNull
    private List<AnswerVersionDto> selectedAnswers;
    @NotNull
    private List<AnswerVersionDto> trueAnswers;
}
