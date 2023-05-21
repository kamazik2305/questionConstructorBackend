package ru.questionConstructorBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.questionConstructorBackend.dto.QuestionDto;
import ru.questionConstructorBackend.dto.QuestionTypeDto;
import ru.questionConstructorBackend.entity.QuestionType;
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

    @GetMapping("/questions/{id_question}")
    public QuestionDto getQuestionById(@PathVariable(value = "id_question") long id)
    {
        return questionService.findQuestionById(id);
    }

    @PutMapping("/questions/{id_question}")
    public QuestionDto updateQuestionById(@PathVariable(value = "id_question") long id,
                                          @RequestBody QuestionDto questionDto)
    {
        return questionService.updateQuestionById(id, questionDto);
    }

    @DeleteMapping("/questions/{id_question}")
    public String deleteQuestionById(@PathVariable(value = "id_question") long id)
    {
        questionService.deleteQuestionById(id);
        return "Question deleted";
    }

    @GetMapping("/search")
    public List<QuestionDto> getQuestionsBySearchString(@RequestParam String searchString)
    {
        return questionService.findQuestionsBySearchString(searchString);
    }


}
