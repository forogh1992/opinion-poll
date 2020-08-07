package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.QuestionnaireDTO;
import com.forogh.opinionPoll.dto.UserDTO;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface QuestionnaireMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    QuestionnaireDTO toQuestionnaireDTO(Questionnaire questionnaire);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    Questionnaire toQuestionnaireEntity(QuestionnaireDTO questionnaireDTO);

    List<QuestionnaireDTO> toQuestionnaireDTO(Page<User> questionnaireList);

    List<QuestionnaireDTO> toQuestionnaireDTO(List<User> questionnaireList);

}
