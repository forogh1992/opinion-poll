package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.QuestionOptionDTO;
import com.forogh.opinionPoll.mapper.QuestionOptionMapper;
import com.forogh.opinionPoll.model.QuestionOption;
import com.forogh.opinionPoll.service.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questionOption")
public class QuestionOptionController {

    @Autowired
    QuestionOptionService questionOptionService;

    @Autowired
    QuestionOptionMapper questionOptionMapper;

    @PostMapping(value = "/{questionId}")
    public ResponseEntity<Void> addQuestionOption(@PathVariable(value = "questionId") Long questionId,
                                                  @Valid @RequestBody QuestionOptionDTO questionOptionDTO) {

        QuestionOption questionOption = questionOptionMapper.toQuestionOptionEntity(questionOptionDTO);
        questionOptionService.addQuestionOption(questionId, questionOption);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }

    @PutMapping(value = "/{questionOptionId}")
    public ResponseEntity<Void> updateQuestionOption(@PathVariable(value = "questionOptionId") Long questionOptionId,
                                                     @RequestBody QuestionOptionDTO questionOptionDTO) {

        QuestionOption questionOption = questionOptionMapper.toQuestionOptionEntity(questionOptionDTO);
        questionOptionService.updateQuestionOption(questionOptionId, questionOption);
        return ResponseEntity.status(HttpsURLConnection.HTTP_OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionOptionDTO> getQuestionOptionById(@PathVariable(value = "id") Long questionOptionId) {

        QuestionOption questionOption = questionOptionService.getQuestionOptionById(questionOptionId);

        QuestionOptionDTO questionOptionDTO = questionOptionMapper.toQuestionOptionDTO(questionOption);
        return ResponseEntity.ok(questionOptionDTO);

    }

    @GetMapping("get/{questionId}")
    public ResponseEntity<List<QuestionOptionDTO>> getOptionByQuestionId(@PathVariable(value = "questionId") Long questionId) {

        List<QuestionOption> questionOption = questionOptionService.getQuestionOptionsByQuestionId(questionId);

        List<QuestionOptionDTO> questionOptionDTO = questionOptionMapper.toQuestionOptionDTO(questionOption);
        return ResponseEntity.ok(questionOptionDTO);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        questionOptionService.deleteQuestionOptionById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
