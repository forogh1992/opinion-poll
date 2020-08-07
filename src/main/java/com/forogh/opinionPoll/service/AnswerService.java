package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.exception.ConflictException;
import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.*;
import com.forogh.opinionPoll.repository.AnswerRepository;
import com.forogh.opinionPoll.repository.AnswerSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService implements IAnswer {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    AnswerSheetRepository answerSheetRepository;

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    AnswerSheetService answerSheetService;

    @Autowired
    QuestionOptionService questionOptionService;

    @Override
    public void addAnswerByQuestionId(Long questionId, Answer answer) {
        Question findQuestion = questionService.getQuestionById(questionId);
        if (findQuestion != null) {
            answer.setQuestion(findQuestion);
            answerRepository.save(answer);
        } else
            throw new NotFoundException("this question not found");
    }


    @Override
    public void addAnswerBySheetAndQuestionId(Long answerSheetId, Long questionId, Answer answer) {

        Optional<AnswerSheet> answerSheetOptional = answerSheetRepository.findById(answerSheetId);
        if (!answerSheetOptional.isPresent()) {
            throw new NotFoundException("this answerSheet not found");
        }
        AnswerSheet answerSheet = answerSheetOptional.get();

        Question question = questionService.getQuestionById(questionId);

        Optional<Answer> findAnswer = answerRepository.findFirstByAnswerSheetAndQuestion(answerSheet, question);
        if (findAnswer.isPresent()) {
            throw new ConflictException("You have already answered this question");
        }

        answer.setQuestion(question);
        answer.setAnswerSheet(answerSheet);
        answerRepository.save(answer);

    }


    @Override
    public Answer update(Long answerId, Answer answer) {
        return null;
    }

    @Override
    public void deleteById(Long answerId) {

    }

    @Override
    public Page<Answer> getAnswersByQuestionId(Long questionId, int page, int pageSize) {

        Question question = questionService.getQuestionById(questionId);

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("id")
        ));
        Page<Answer> answerPage = answerRepository.findAllByQuestion(question, pageable);
        return answerPage;

    }
    @Override
    public Page<Answer> getAnswersByAnswerSheet(Long answerSheetId, int page, int pageSize) {

        AnswerSheet answerSheet = answerSheetService.getById(answerSheetId);
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Order.desc("id")
        ));
        Page<Answer> answerPage = answerRepository.findAllByAnswerSheet(answerSheet, pageable);
        return answerPage;
    }

    @Override
    public Answer getAnswerById(Long answerId) {
        Optional<Answer> findAnswerById = answerRepository.findById(answerId);
        if (findAnswerById.isPresent()) {
            return findAnswerById.get();
        } else throw new NotFoundException("this answer not found");
    }

    @Override
    public List<Answer> getUserAnswersByQuestionnaire(Long answersheetId) {
        Optional<AnswerSheet> answerSheetOptional = answerSheetRepository.findById(answersheetId);

        if (!answerSheetOptional.isPresent()) {

            throw new NotFoundException("");
        }

        AnswerSheet answerSheet = answerSheetOptional.get();
        List<Answer> answerList = answerRepository.findAllByAnswerSheet(answerSheet);
        return answerList;
    }

    @Override
    public void addAnswers(List<Answer> answers) {

    }

    @Override
    public void addAnswers(Long userId, Long questionnaireId, List<Answer> answers) {
       AnswerSheet answerSheet= answerSheetService.add(userId,questionnaireId);

       answers.forEach(answer -> {

         Question question=  questionService.getQuestionById(answer.getQuestionId());

         if (question.getQuestionType()==QuestionType.MULTI_CHOICE||question.getQuestionType()==QuestionType.SINGLE_CHOICE){

            List<Long> answerOptions= answer.getAnswerOptionIds();
             List<AnswerOption> answerOptionsList= new ArrayList<>();


            answerOptions.forEach(aLong -> {

              QuestionOption questionOption=  questionOptionService.getQuestionOptionById(aLong);


              AnswerOption answerOption= new AnswerOption();
              answerOption.setQuestionOption(questionOption);
              answerOption.setAnswer(answer);

              answerOptionsList.add(answerOption);

            });
//             QuestionOption questionOption= questionOptionService.getQuestionOptionById();
             answer.setAnswerOptions(answerOptionsList);

         }

           answer.setQuestion(question);//get question Object
           answer.setAnswerSheet(answerSheet);



       });

       answerRepository.saveAll(answers);
    }
}
