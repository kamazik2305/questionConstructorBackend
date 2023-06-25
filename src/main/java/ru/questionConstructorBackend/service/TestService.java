package ru.questionConstructorBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.questionConstructorBackend.dto.TestDto;
import ru.questionConstructorBackend.entity.Test;
import ru.questionConstructorBackend.mapper.TestMapper;
import ru.questionConstructorBackend.repository.TestRepository;

import java.util.List;


@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestMapper testMapper;

    public List<TestDto> findAllTests() {
        return testRepository
                .findAll()
                .stream()
                .map(test -> testMapper.toDto(test))
                .toList();
    }

    public TestDto findTestById(long id) {
        return testMapper.toDto(testRepository.findById(id).get());
    }

    public TestDto addTest(TestDto testDto) {
        Test test = testMapper.toEntity(testDto);
        testRepository.save(test);

        return testMapper.toDto(test);
    }

    public void updateTest(long idTest, TestDto testDto) {
        Test test = testRepository.findById(idTest).get();
        test.setTestName(testDto.getTestName());
        testRepository.save(test);
    }

    public void deleteTestById(long idTest) {
        testRepository.deleteById(idTest);
    }

}
