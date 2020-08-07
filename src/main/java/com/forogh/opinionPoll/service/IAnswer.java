package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.model.Answer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAnswer {

    void addAnswerByQuestionId(Long questionId, Answer answer);

    void addAnswerBySheetAndQuestionId(Long answerSheetId, Long questionId, Answer answer);

    Answer update(Long answerId, Answer answer);

    void deleteById(Long answerId);

    Page<Answer> getAnswersByQuestionId(Long questionId, int page, int pageSize);

    Page<Answer> getAnswersByAnswerSheet(Long answerSheetId, int page, int pageSize);

    Answer getAnswerById(Long answerId);

    List<Answer> getUserAnswersByQuestionnaire(Long answersheetId);

    void addAnswers (List<Answer> answers);
    void addAnswers (Long userId, Long questionnaireId, List<Answer> answers);




}
