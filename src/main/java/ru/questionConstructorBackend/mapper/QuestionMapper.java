package ru.questionConstructorBackend.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.questionConstructorBackend.dto.AnswerVersionDto;
import ru.questionConstructorBackend.dto.QuestionDto;
import ru.questionConstructorBackend.entity.Question;
import ru.questionConstructorBackend.repository.AnswerVersionRepository;
import ru.questionConstructorBackend.repository.QuestionRepository;
import ru.questionConstructorBackend.repository.QuestionTypeRepository;

@Component
@RequiredArgsConstructor
public class QuestionMapper {


    private final QuestionTypeRepository questionTypeRepository;

    private final AnswerVersionRepository answerVersionRepository;

    private final QuestionRepository questionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Question toEntity(QuestionDto questionDto)
    {
        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText());
        question.setQuestionType(questionTypeRepository.findById(questionDto.getIdQuestionType()).get());
        return question;

    }

    public QuestionDto toDto(Question question)
    {
        switch ((int) question.getQuestionType().getId())
        {
            case 1,3: return QuestionDto
                    .builder()
                    .id(question.getId())
                    .idQuestionType(question.getQuestionType().getId())
                    .questionText(question.getQuestionText())
                    .answerVersions(question.getAnswerVersions()
                            .stream()
                            .map(answerVersion -> AnswerVersionDto.builder()
                                    .answerText(answerVersion.getAnswerText())
                                    .verity(passwordEncoder.encode(answerVersion.getVerity().toString()))
                                    .build())
                            .toList())
                    .build();
            default: return QuestionDto
                    .builder()
                    .id(question.getId())
                    .idQuestionType(question.getQuestionType().getId())
                    .questionText(question.getQuestionText())
                    .answerVersions(question.getAnswerVersions()
                            .stream()
                            .map(answerVersion -> AnswerVersionDto.builder()
                                    .answerText(passwordEncoder.encode(answerVersion.getAnswerText()))
                                    .verity(passwordEncoder.encode(answerVersion.getVerity().toString()))
                                    .build())
                            .toList())
                    .build();
        }

    }





}
