package ru.questionConstructorBackend.dto.checkQuestionDto;

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
public class CheckQuestionType2Dto {

    @NotEmpty
    private String questionText;
    @NotEmpty
    private String writelnAnswer;
    @NotNull
    private List<AnswerVersionDto> trueAnswers;

}
