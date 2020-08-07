package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.AnswerDTO;
import com.forogh.opinionPoll.dto.UserDTO;
import com.forogh.opinionPoll.mapper.AnswerMapper;

import com.forogh.opinionPoll.model.Answer;
import com.forogh.opinionPoll.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerMapper answerMapper;

    @PostMapping(value = "/addAnswer/{questionId}")
    public ResponseEntity<Void> addNewAnswer(@PathVariable(value = "questionId") Long questionId,
                                             @Valid @RequestBody AnswerDTO answerDTO) {

        answerService.addAnswerByQuestionId(questionId, answerMapper.toAnswerEntity(answerDTO));
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }


    @PostMapping(value = "/addAnswer/{answerSheetId}/{questionId}")
    public ResponseEntity<Void> addNewAnswer(@PathVariable(value = "answerSheetId") Long answerSheetId,
                                             @PathVariable(value = "questionId") Long questionId,
                                             @Valid @RequestBody AnswerDTO answerDTO) {

        Answer answer = answerMapper.toAnswerEntity(answerDTO);
        answerService.addAnswerBySheetAndQuestionId(answerSheetId, questionId, answer);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }

  /*  @GetMapping("/{questionId}/{page}/{size}")
    public ResponseEntity<List<AnswerDTO>> getAnswerByQuestionId(@PathVariable("questionId") Long questionId,
                                                                 @PathVariable("page") int page,
                                                                 @PathVariable("size") int size) {
        return ResponseEntity.ok(answerMapper.toAnswerDTO(answerService.getAnswersByQuestionId(questionId, page, size)));
    }*/
/*
    @GetMapping("/{answersheet}/{page}/{size}")
    public ResponseEntity<List<AnswerDTO>> getAnswerByAnswerSheetId(@PathVariable("answersheet") Long answerSheetId,
                                                                    @PathVariable("page") int page,
                                                                    @PathVariable("size") int size) {
        return ResponseEntity.ok(answerMapper.toAnswerDTO(answerService.getAnswersByAnswerSheet(answerSheetId, page, size)));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(answerMapper.toAnswerDTO(answerService.getAnswerById(id)));
    }

    @PostMapping(value = "/addAnswers/{questionnaireId}/{userId}")
    public ResponseEntity<Void> addNewAnswers(@PathVariable(value = "questionnaireId") Long questionnaireId,
                                             @PathVariable(value = "userId") Long userId,
                                             @Valid @RequestBody List<AnswerDTO> answerDTOs) {

        answerService.addAnswers(userId,questionnaireId, answerMapper.toAnswers(answerDTOs));
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }
}
