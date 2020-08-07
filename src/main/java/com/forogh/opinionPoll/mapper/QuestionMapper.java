package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.QuestionDTO;
import com.forogh.opinionPoll.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "questionType", target = "questionType")
    QuestionDTO toQuestionDTO(Question question);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "questionType", target = "questionType")
    Question toQuestionEntity(QuestionDTO questionDTO);

    List<QuestionDTO> toQuestionDTO(Page<Question> questionList);

    List<QuestionDTO> toQuestionDTO(List<Question> questionList);
}
