package ru.questionConstructorBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.questionConstructorBackend.dto.TestDto;
import ru.questionConstructorBackend.service.TestService;

import java.util.List;

@RestController
@CrossOrigin
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/tests")
    public List<TestDto> getAllTests() {
        return testService.findAllTests();
    }


    @GetMapping("tests/{id_test}")
    public TestDto getTestById(@PathVariable(value = "id_test") long id,
                               @RequestBody TestDto testDto) {
        return testService.findTestById(id);
    }

    @PostMapping("tests/add")
    public TestDto addTest(@RequestBody TestDto testDto) {
        return testService.addTest(testDto);
    }


    @PutMapping("tests/{id_test}")
    public ResponseEntity updateTest(@PathVariable(value = "id_test") long id,
                                     @RequestBody TestDto testDto) {
        testService.updateTest(id, testDto);
        return ResponseEntity.ok("Название теста обновлено на " + testDto.getTestName());
    }

    @DeleteMapping("/tests/{id_test}")
    public ResponseEntity deleteTest(@PathVariable(value = "id_test") long id) {
        testService.deleteTestById(id);
        return ResponseEntity.ok("Тест удалён");
    }

}
