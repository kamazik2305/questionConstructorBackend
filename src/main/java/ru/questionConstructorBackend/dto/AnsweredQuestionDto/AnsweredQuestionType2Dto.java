package ru.questionConstructorBackend.dto.AnsweredQuestionDto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnsweredQuestionType2Dto {

    @NotEmpty
    private String questionText;
    @NotNull
    private List<String> trueAnswers;
    @NotNull
    private String writelnAnswer;
}
