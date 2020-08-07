package com.forogh.opinionPoll.mapper;

import com.forogh.opinionPoll.dto.AnswerDTO;
import com.forogh.opinionPoll.dto.AnswerSheetDTO;
import com.forogh.opinionPoll.model.Answer;
import com.forogh.opinionPoll.model.AnswerSheet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerSheetMapper {

    @Mapping(source = "id", target = "id")
    AnswerSheetDTO toAnswerSheetDTO(AnswerSheet answerSheet);

    @Mapping(source = "id", target = "id")

    AnswerSheet toAnswerSheetEntity(AnswerSheetDTO answerSheetDTO);

    List<AnswerSheetDTO> toAnswerSheetDTO(Page<AnswerSheet> answersList);

    List<AnswerSheetDTO> toAnswerSheetDTO(List<AnswerSheet> answersList);
}
