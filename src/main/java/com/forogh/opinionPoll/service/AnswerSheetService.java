package com.forogh.opinionPoll.service;

import com.forogh.opinionPoll.exception.NotFoundException;
import com.forogh.opinionPoll.model.AnswerSheet;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.model.User;
import com.forogh.opinionPoll.repository.AnswerSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerSheetService implements IAnswerSheet {
    @Autowired
    AnswerSheetRepository answerSheetRepository;

    @Autowired
    UserService userService;

    @Autowired
    QuestionnaireService questionnaireService;

    @Override
    public AnswerSheet add(Long userId, Long questionnaireId) {

        User user= userService.getById(userId);
        Questionnaire questionnaire= questionnaireService.getQuestionnaire(questionnaireId);

        AnswerSheet answerSheet= new AnswerSheet();

        answerSheet.setUser(user);
        answerSheet.setQuestionnaire(questionnaire);

       AnswerSheet savedAnswerSheet= answerSheetRepository.save(answerSheet);
       userService.updateTotalAnswerSheet(user);
       return savedAnswerSheet;

    }

    @Override
    public AnswerSheet getById(Long id) {
        Optional<AnswerSheet> findAnswerSheetById = answerSheetRepository.findById(id);
        if (findAnswerSheetById.isPresent()) {
            return findAnswerSheetById.get();
        } else throw new NotFoundException("this answer sheet not found");
    }

    @Override
    public List<AnswerSheet> answerSheets(Long Id) {
        return null;
    }


}

