package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.AnswerSheet;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AnswerSheetRepository extends PagingAndSortingRepository<AnswerSheet, Long> {

    Page<AnswerSheet> findAllByQuestionnaire(Questionnaire questionnaire, Pageable pageable);

    Optional<AnswerSheet> findById(Long id);

    Optional<AnswerSheet> findByUserAndQuestionnaire(User user, Questionnaire questionnaire);

    Page<AnswerSheet> findAllByUser(User user, Pageable pageable);

    Page<AnswerSheet> findAll(Pageable pageable);

}
