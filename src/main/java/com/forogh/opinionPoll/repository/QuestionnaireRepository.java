package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface QuestionnaireRepository extends PagingAndSortingRepository<Questionnaire, Long> {

    Page<Questionnaire> findAllByUser(Pageable pageable, User user);

    Optional<Questionnaire> findById(Long id);

    Optional<Questionnaire> findByTitle(String title);

    Page<Questionnaire> findAll(Pageable pageable);


}
