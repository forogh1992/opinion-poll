package com.forogh.opinionPoll.service;


import com.forogh.opinionPoll.exception.ConflictException;
import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.Question;
import com.forogh.opinionPoll.model.QuestionOption;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.repository.QuestionOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionOptionService implements IQuestionOption {

    @Autowired
    QuestionOptionRepository questionOptionRepository;

    @Autowired
    IQuestion questionService;

    @Override
    public void addQuestionOption(Long questionId, QuestionOption questionOption) {
        Question question = questionService.getQuestionById(questionId);
        Optional<QuestionOption> optionalQuestionOption = questionOptionRepository.findByTitle(questionOption.getTitle());

        if (optionalQuestionOption.isPresent()) {

            throw new ConflictException("this questionOption already exist");
        } else if (question != null) {
            questionOption.setQuestion(question);
            questionOptionRepository.save(questionOption);
        } else
            throw new NotFoundException("this user  not found:");


    }

    @Override
    public QuestionOption updateQuestionOption(Long questionOptionId, QuestionOption questionOption) {
        Optional<QuestionOption> findQuestionOption = questionOptionRepository.findById(questionOptionId);

        if (findQuestionOption.isPresent()) {
            QuestionOption updateQuestionOption = findQuestionOption.get();
            updateQuestionOption.setTitle(questionOption.getTitle());
            questionOptionRepository.save(updateQuestionOption);
            return updateQuestionOption;
        } else {
            throw new NotFoundException("Not found this questionOption ");
        }
    }

    @Override
    public QuestionOption getQuestionOptionById(Long questionOptionId) {

        Optional<QuestionOption> findQuestionOptionById = questionOptionRepository.findById(questionOptionId);
        if (findQuestionOptionById.isPresent()) {
            return findQuestionOptionById.get();
        } else throw new NotFoundException("not found this question option");

    }

    @Override
    public List<QuestionOption> getQuestionOptionsByQuestionId(Long questionId) {
//        Optional<Question> findQuestionById = Optional.ofNullable(questionService.getQuestionById(questionId));
        Question findQuestionById = questionService.getQuestionById(questionId);

        List<QuestionOption> questionOption = questionOptionRepository.findAllByQuestion((findQuestionById));
        return questionOption;
    }

    @Override
    public void deleteQuestionOptionById(Long questionOptionId) {
        Optional<QuestionOption> QfindById = questionOptionRepository.findById(questionOptionId);

        if (QfindById.isPresent()) {
            questionOptionRepository.deleteById(questionOptionId);
        } else throw new NotFoundException("this question option not found");

    }
}
