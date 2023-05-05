package ru.questionConstructorBackend.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.questionConstructorBackend.dto.QuestionTypeDto;
import ru.questionConstructorBackend.entity.QuestionType;
import ru.questionConstructorBackend.repository.QuestionTypeRepository;

@Component
@RequiredArgsConstructor
public class QuestionTypeMapper {

    private final QuestionTypeRepository questionTypeRepository;

    public QuestionType toEntity(QuestionTypeDto questionTypeDto)
    {
        QuestionType questionType = new QuestionType();
        questionType.setTypeName(questionTypeDto.getTypeName());
        return questionType;
    }

    public QuestionTypeDto toDto(QuestionType questionType)
    {
        return QuestionTypeDto
                .builder()
                .id(questionType.getId())
                .typeName(questionType.getTypeName())
                .build();
    }


}
