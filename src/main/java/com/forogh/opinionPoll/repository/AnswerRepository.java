package com.forogh.opinionPoll.repository;

import com.forogh.opinionPoll.model.Answer;
import com.forogh.opinionPoll.model.AnswerSheet;
import com.forogh.opinionPoll.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends PagingAndSortingRepository<Answer,Long> {


    Optional<Answer> findFirstByAnswerSheetAndQuestion(AnswerSheet answerSheet, Question question);
    Page<Answer> findAllByQuestion (Question question, Pageable pageable);
    Page<Answer> findAllByAnswerSheet(AnswerSheet answerSheet, Pageable pageable);
    List<Answer> findAllByAnswerSheet(AnswerSheet answerSheet);
    Optional<Answer> findByAnswerSheet(Long id);

}
