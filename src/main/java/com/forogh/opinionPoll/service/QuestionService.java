package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.Question;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestion {


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionnaireService questionnaireService;

    @Override
    public void addQuestion(Long questionnaireId, Question question) {
        Questionnaire questionnaire = (questionnaireService.getQuestionnaire(questionnaireId));

        if (questionnaire != null) {
            question.setQuestionnaire(questionnaire);
            questionRepository.save(question);
        } else
            throw new NotFoundException("this questionnaire  not found");
    }

    @Override
    public Question update(Long questionId, Question question) {
        Optional<Question> findQuestion = questionRepository.findById(questionId);

        if (findQuestion.isPresent()) {
            Question updateQuestion = findQuestion.get();
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setQuestionType(question.getQuestionType());
            questionRepository.save(updateQuestion);
            return updateQuestion;
        } else {
            throw new NotFoundException("Not found this question");
        }
    }

    @Override
    public void deleteById(Long questionId) {

    }

    @Override
    public List<Question> getQuestionByqQuestionnaire(Long questionnaireId) {
        Questionnaire findQuestionnaire= questionnaireService.getQuestionnaire(questionnaireId);
        List<Question> questions=questionRepository.findAllByQuestionnaire(findQuestionnaire);
        return questions;
    }

    @Override
    public Question getQuestionById(Long questionId) {
        Optional<Question> findQuestionById= questionRepository.findById(questionId);
        if (findQuestionById.isPresent())
            return findQuestionById.get();
        else
            throw new RuntimeException();
    }

    @Override
    public void updateTotalAnswerSheet(Question question) {

    }
}
