package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.QuestionOptionDTO;
import com.forogh.opinionPoll.model.QuestionOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionOptionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    QuestionOptionDTO toQuestionOptionDTO(QuestionOption questionOption);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    QuestionOption toQuestionOptionEntity(QuestionOptionDTO questionOptionDTO);

    List<QuestionOptionDTO> toQuestionOptionDTO(Page<QuestionOption> questionOptionsList);

    List<QuestionOptionDTO> toQuestionOptionDTO(List<QuestionOption> questionOptionsList);
}
