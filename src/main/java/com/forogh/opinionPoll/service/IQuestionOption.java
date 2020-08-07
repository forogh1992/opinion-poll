package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.QuestionOption;

import java.util.List;

public interface IQuestionOption {

    void addQuestionOption(Long questionId, QuestionOption questionOption);

    QuestionOption updateQuestionOption(Long questionOptionId, QuestionOption questionOption);

    QuestionOption getQuestionOptionById(Long questionOptionId);

    List<QuestionOption> getQuestionOptionsByQuestionId(Long questionId);

    void deleteQuestionOptionById(Long questionOptionId);
}
