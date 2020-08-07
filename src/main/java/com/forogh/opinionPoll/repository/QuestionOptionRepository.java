package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.Question;
import com.forogh.opinionPoll.model.QuestionOption;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionOptionRepository extends PagingAndSortingRepository<QuestionOption, Long> {

    List<QuestionOption> findAllByQuestion(Question question);
    Optional<QuestionOption> findById(Long id);
    Optional<QuestionOption> findByTitle(String title);


}
