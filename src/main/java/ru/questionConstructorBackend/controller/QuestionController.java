package ru.questionConstructorBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.questionConstructorBackend.dto.QuestionDto;
import ru.questionConstructorBackend.dto.QuestionTypeDto;
import ru.questionConstructorBackend.service.QuestionService;

import java.util.List;


@RestController
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question-types")
    public List<QuestionTypeDto> getAllQuestionTypes()
    {
        return questionService.findAllQuestionTypes();
    }

    @GetMapping("/questions")
    public List<QuestionDto> getAllQuestions()
    {
        return questionService.findAllQuestions();
    }

    @PostMapping("/questions/add")
    public QuestionDto addQuestion(@RequestBody QuestionDto questionDto)
    {
        return questionService.addQuestion(questionDto);
    }


}
