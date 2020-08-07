package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.Question;
import com.forogh.opinionPoll.model.Questionnaire;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository  extends PagingAndSortingRepository<Question, Long> {

    List<Question> findAllByQuestionnaire(Questionnaire questionnaire);
}
