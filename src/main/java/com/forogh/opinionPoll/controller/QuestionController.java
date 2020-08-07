package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.QuestionDTO;
import com.forogh.opinionPoll.dto.QuestionOptionDTO;
import com.forogh.opinionPoll.mapper.QuestionMapper;
import com.forogh.opinionPoll.model.Question;
import com.forogh.opinionPoll.model.QuestionOption;
import com.forogh.opinionPoll.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionMapper questionMapper;

    @PostMapping("/add/{questionnaireId}")
    public ResponseEntity<Void> addQuestion(@PathVariable(value = "questionnaireId") Long questionnaireId,
                                            @Valid QuestionDTO questionDTO) {
        questionService.addQuestion(questionnaireId, questionMapper.toQuestionEntity(questionDTO));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@Valid QuestionDTO questionDTO,
                                           @PathVariable("id") Long id) {
        return ResponseEntity.ok(questionService.update(id, questionMapper.toQuestionEntity(questionDTO)));
    }

    @GetMapping("{questionnaireId}")
    public ResponseEntity<List<QuestionDTO>> getQuestionsByQuestionnaire(@PathVariable(value = "questionnaireId") Long questionnaireId) {

        List<Question> question = questionService.getQuestionByqQuestionnaire(questionnaireId);

        List<QuestionDTO> questionDTO = questionMapper.toQuestionDTO(question);
        return ResponseEntity.ok(questionDTO);

    }

}
