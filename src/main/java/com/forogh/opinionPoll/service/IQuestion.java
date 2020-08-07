package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.Question;

import java.util.List;

public interface IQuestion {

    void addQuestion(Long questionnaireId, Question question);

    Question update(Long questionId, Question question);

    void deleteById(Long questionId);

    List<Question> getQuestionByqQuestionnaire(Long questionnaireId);

    Question getQuestionById(Long questionId);

    void updateTotalAnswerSheet(Question question);

}
