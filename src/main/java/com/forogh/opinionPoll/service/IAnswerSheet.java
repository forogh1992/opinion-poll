package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.AnswerSheet;

import java.util.List;

public interface IAnswerSheet {

    AnswerSheet add(Long userId, Long questionnaireId);

    AnswerSheet getById(Long Id);

    List<AnswerSheet> answerSheets (Long Id);

}
