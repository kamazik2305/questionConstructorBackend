package ru.questionConstructorBackend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerVersionDto {

    @NotNull
    private long id;
    @NotEmpty
    private String answerText;
    @NotNull
    private Boolean verity;

}
