package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.AnswerDTO;
import com.forogh.opinionPoll.dto.UserDTO;
import com.forogh.opinionPoll.model.Answer;
import com.forogh.opinionPoll.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "intValue", target = "intValue")
    @Mapping(source = "stringValue", target = "stringValue")
    @Mapping(source = "doubleValue", target = "doubleValue")
    AnswerDTO toAnswerDTO(Answer answer);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "intValue", target = "intValue")
    @Mapping(source = "stringValue", target = "stringValue")
    @Mapping(source = "doubleValue", target = "doubleValue")
    Answer toAnswerEntity(AnswerDTO answerDTO);

    List<AnswerDTO> toAnswerDTO(List<Answer> answersList);

    List<Answer> toAnswers(List<AnswerDTO> answersList);
}
