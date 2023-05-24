package ru.questionConstructorBackend.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnswerVersionDto {

    @NotEmpty
    private String answerText;
    @NotNull
    private Boolean verity;

}
