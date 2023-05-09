package ru.questionConstructorBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.questionConstructorBackend.dto.AnswerVersionDto;
import ru.questionConstructorBackend.dto.QuestionDto;
import ru.questionConstructorBackend.dto.QuestionTypeDto;
import ru.questionConstructorBackend.entity.AnswerVersion;
import ru.questionConstructorBackend.entity.Question;
import ru.questionConstructorBackend.mapper.QuestionMapper;
import ru.questionConstructorBackend.mapper.QuestionTypeMapper;
import ru.questionConstructorBackend.repository.AnswerVersionRepository;
import ru.questionConstructorBackend.repository.QuestionRepository;
import ru.questionConstructorBackend.repository.QuestionTypeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerVersionRepository answerVersionRepository;
    @Autowired
    private QuestionTypeMapper questionTypeMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionTypeDto> findAllQuestionTypes() {
        return questionTypeRepository
                .findAll()
                .stream()
                .map(questionType -> questionTypeMapper.toDto(questionType))
                .toList();
    }

    public List<QuestionDto> findAllQuestions() {

        ArrayList<QuestionDto> questionDtoList = questionRepository
                .findAll()
                .stream()
                .map(question -> questionMapper.toDto(question))
                .collect(Collectors
                        .toCollection(ArrayList :: new));
        Collections.shuffle(questionDtoList);
        return questionDtoList;
//        return questionRepository
//                .findAll()
//                .stream()
//                .map(question -> questionMapper.toDto(question))
//                .toList();
    }

    public QuestionDto findQuestionById(long id)
    {
        return questionMapper.toDto(questionRepository.findById(id).orElseThrow());
    }

    public QuestionDto updateQuestionById(long id, QuestionDto questionDto)
    {
        Question question = questionRepository.findById(id).orElseThrow();
        question.setQuestionText(questionDto.getQuestionText());
        questionRepository.save(question);
        return questionMapper.toDto(question);
    }

    public void deleteQuestionById(long id)
    {
        questionRepository.deleteById(id);
    }



    public QuestionDto addQuestion(QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        questionRepository.save(question);

        List<AnswerVersion> answerVersions = new ArrayList<>();
        for (AnswerVersionDto answerVersionDto : questionDto.getAnswerVersions()) {
            AnswerVersion answerVersion = new AnswerVersion();
            answerVersion.setAnswerText(answerVersionDto.getAnswerText());
            answerVersion.setQuestion(question);
            answerVersionRepository.save(answerVersion);
            answerVersions.add(answerVersion);
        }
        question.setAnswerVersions(answerVersions);
        //questionRepository.save(question);

        return questionMapper.toDto(question);
    }

}
