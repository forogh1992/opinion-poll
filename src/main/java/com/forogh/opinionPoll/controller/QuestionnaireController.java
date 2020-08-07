package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.QuestionnaireDTO;
import com.forogh.opinionPoll.mapper.QuestionnaireMapper;
import com.forogh.opinionPoll.model.Questionnaire;
import com.forogh.opinionPoll.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionnaireMapper questionnaireMapper;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Void> createQuestionnaire(@PathVariable(value = "userId") Long userId,
                                                    @Valid @RequestBody QuestionnaireDTO questionnaireDTO) {
        questionnaireService.add(questionnaireMapper.toQuestionnaireEntity(questionnaireDTO), userId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questionnaire> update(@Valid QuestionnaireDTO questionnaireDTO,
                                                @PathVariable("id") Long id) {
        return ResponseEntity.ok(questionnaireService.update(id, questionnaireMapper.toQuestionnaireEntity(questionnaireDTO)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        questionnaireService.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
