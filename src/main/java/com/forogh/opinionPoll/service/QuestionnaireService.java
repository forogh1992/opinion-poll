package com.forogh.opinionPoll.service;


import com.forogh.opinionPoll.exception.ConflictException;
import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.model.User;
import com.forogh.opinionPoll.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class QuestionnaireService implements IQuestionnaire{
    @Autowired
    UserService userService;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Override
    public void add(Questionnaire questionnaire, Long userId) {

        User user = (userService.getUser(userId));
        Optional<Questionnaire> findQuestionnaire = questionnaireRepository.findByTitle(questionnaire.getTitle());

        if (findQuestionnaire.isPresent()){
            throw new ConflictException("this questionnaire already exist");
        }else if (user!=null){
            questionnaire.setUser(user);
            questionnaireRepository.save(questionnaire);
        }else
            throw new NotFoundException("this user  not found:");
    }

    @Override
    public Questionnaire update(Long questionnaireId, Questionnaire questionnaire) {
        Optional<Questionnaire> findQ = questionnaireRepository.findById(questionnaireId);

        if (findQ.isPresent()) {
            Questionnaire updateQuestionnaire = findQ.get();
            updateQuestionnaire.setTitle(questionnaire.getTitle());
            questionnaireRepository.save(updateQuestionnaire);
            return updateQuestionnaire;
        } else {
            throw new NotFoundException("Not found this user");
        }
    }


    @Override
    public void deleteById(Long questionnaireId) {
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(questionnaireId);
        if (questionnaire.isPresent()) {
            questionnaireRepository.deleteById(questionnaireId);
        } else {
            throw new NotFoundException("Not found user");
        }

    }

    @Override
    public Questionnaire getQuestionnaire(Long questionnaireId) {
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(questionnaireId);
        if (questionnaire.isPresent())
            return questionnaire.get();
        else
            throw new RuntimeException();
    }





}
