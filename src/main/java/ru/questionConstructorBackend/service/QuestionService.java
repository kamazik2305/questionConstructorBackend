package ru.questionConstructorBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.questionConstructorBackend.dto.QuestionDto;
import ru.questionConstructorBackend.dto.QuestionTypeDto;
import ru.questionConstructorBackend.entity.Question;
import ru.questionConstructorBackend.mapper.QuestionMapper;
import ru.questionConstructorBackend.mapper.QuestionTypeMapper;
import ru.questionConstructorBackend.repository.QuestionRepository;
import ru.questionConstructorBackend.repository.QuestionTypeRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionTypeMapper questionTypeMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionTypeDto> findAllQuestionTypes()
    {
        return questionTypeRepository
                .findAll()
                .stream()
                .map(questionType -> questionTypeMapper.toDto(questionType))
                .toList();
    }

    public List<QuestionDto> findAllQuestions()
    {
        return questionRepository
                .findAll()
                .stream()
                .map(question -> questionMapper.toDto(question))
                .toList();
    }


    //todo как добавляются варианты ответа?
    public QuestionDto addQuestion(QuestionDto questionDto)
    {
        Question question = questionMapper.toEntity(questionDto);
        questionRepository.save(question);
        return questionMapper.toDto(question);
    }

}
