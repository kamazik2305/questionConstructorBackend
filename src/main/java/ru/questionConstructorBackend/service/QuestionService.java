package ru.questionConstructorBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.questionConstructorBackend.dto.*;
import ru.questionConstructorBackend.dto.AnsweredQuestionDto.AnsweredQuestionType2Dto;
import ru.questionConstructorBackend.dto.AnsweredQuestionDto.AnsweredQuestionType3Dto;
import ru.questionConstructorBackend.dto.checkQuestionDto.CheckQuestionType2Dto;
import ru.questionConstructorBackend.dto.checkQuestionDto.CheckQuestionType3Dto;
import ru.questionConstructorBackend.entity.AnswerVersion;
import ru.questionConstructorBackend.entity.Question;
import ru.questionConstructorBackend.mapper.QuestionMapper;
import ru.questionConstructorBackend.mapper.QuestionTypeMapper;
import ru.questionConstructorBackend.repository.AnswerVersionRepository;
import ru.questionConstructorBackend.repository.QuestionRepository;
import ru.questionConstructorBackend.repository.QuestionTypeRepository;
import ru.questionConstructorBackend.repository.TestRepository;

import java.util.*;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TestRepository testRepository;


    public ArrayList<QuestionTypeDto> findAllQuestionTypes() {
        return questionTypeRepository
                .findAll()
                .stream()
                .map(questionType -> questionTypeMapper.toDto(questionType))
                .collect(Collectors.
                        toCollection(ArrayList::new));
    }

    public List<QuestionDto> findAllQuestions() {

//        ArrayList<QuestionDto> questionDtoList = questionRepository
//                .findAll()
//                .stream()
//                .map(question -> questionMapper.toDto(question))
//                .collect(Collectors
//                        .toCollection(ArrayList :: new));
//        Collections.shuffle(questionDtoList);
//        return questionDtoList; - вопросы вперемешку
        return questionRepository
                .findAll()
                .stream()
                .map(question -> questionMapper.toDto(question))
                .toList();
    }

    public List<QuestionDto> findAllQuestionsByTest(long idTest)
    {
        return questionRepository
                .findAllByTest(testRepository.findById(idTest).get())
                .stream()
                .map(question -> questionMapper.toDto(question))
                .toList();
    }

    public QuestionDto findQuestionById(long id) {
        return questionMapper.toDto(questionRepository.findById(id).orElseThrow());
    }


    public QuestionDto updateQuestionById(long id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.setQuestionText(questionDto.getQuestionText());
        questionRepository.save(question);
        return questionMapper.toDto(question);
    }

    public void deleteQuestionById(long id) {
        questionRepository.deleteById(id);
    }


    public QuestionDto addQuestion(QuestionDto questionDto, long idTest) {

        Question question = new Question();
        question.setQuestionType(questionTypeRepository.findById(questionDto.getIdQuestionType()).get());
        question.setTest(testRepository.findById(idTest).get());
        question.setQuestionText(questionDto.getQuestionText());
//        Question question = questionMapper.toEntity(questionDto);
//        questionRepository.save(question);
        questionRepository.save(question);
        List<AnswerVersion> answerVersions = new ArrayList<>();
        for (AnswerVersionDto answerVersionDto : questionDto.getAnswerVersions()) {
            AnswerVersion answerVersion = new AnswerVersion();
            answerVersion.setAnswerText(answerVersionDto.getAnswerText());
            if (Objects.equals(answerVersionDto.getVerity(), "true"))
                answerVersion.setVerity(true);
            else answerVersion.setVerity(false);
            answerVersion.setQuestion(question);
            answerVersionRepository.save(answerVersion);
            answerVersions.add(answerVersion);
        }
        question.setAnswerVersions(answerVersions);


        return questionMapper.toDto(question);
    }

    public List<QuestionDto> findQuestionsBySearchString(String SearchString) {
        return questionRepository.findAllByQuestionTextContains(SearchString).stream()
                .map(question -> questionMapper.toDto(question))
                .toList();
    }


    public Boolean checkQuestionType1(AnswerVersionDto answerVersionDto) {
        return passwordEncoder.matches("true", answerVersionDto.getVerity());
    }

    public AnsweredQuestionType3Dto checkQuestionType13(CheckQuestionType3Dto checkQuestion) {
        AnsweredQuestionType3Dto answeredQuestion = new AnsweredQuestionType3Dto();
        List<AnswerVersionDto> trueAnswers = new ArrayList<>();
        for (AnswerVersionDto answer : checkQuestion.getAnswers()) {
            if (passwordEncoder.matches("true", answer.getVerity()))
                trueAnswers.add(answer);
        }
        answeredQuestion.setQuestionText(checkQuestion.getQuestionText());
        answeredQuestion.setSelectedAnswers(checkQuestion.getSelectedAnswers());
        answeredQuestion.setTrueAnswers(trueAnswers);
        return answeredQuestion;
    }
}
