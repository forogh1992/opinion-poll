package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.Questionnaire;
import org.springframework.data.domain.Page;



public interface IQuestionnaire {

    void add(Questionnaire questionnaire, Long userId);

    Questionnaire update(Long questionnaireId, Questionnaire questionnaire);

    Questionnaire getQuestionnaire(Long questionnaireId);

    void deleteById(Long questionnaireId);


}
