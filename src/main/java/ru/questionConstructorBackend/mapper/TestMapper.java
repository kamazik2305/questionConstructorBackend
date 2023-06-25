package ru.questionConstructorBackend.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.questionConstructorBackend.dto.TestDto;
import ru.questionConstructorBackend.entity.Test;
import ru.questionConstructorBackend.repository.TestRepository;

@Component
@RequiredArgsConstructor
public class TestMapper {

    private final TestRepository testRepository;

    public Test toEntity(TestDto testDto)
    {
        Test test = new Test();
        test.setTestName(testDto.getTestName());
        return test;
    }

    public TestDto toDto(Test test)
    {
        return TestDto
                .builder()
                .id(test.getId())
                .testName(test.getTestName())
                .build();
    }
}
