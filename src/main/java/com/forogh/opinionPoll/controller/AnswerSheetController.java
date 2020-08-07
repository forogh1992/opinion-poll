package com.forogh.opinionPoll.controller;

import com.forogh.opinionPoll.dto.AnswerDTO;
import com.forogh.opinionPoll.dto.AnswerSheetDTO;
import com.forogh.opinionPoll.mapper.AnswerSheetMapper;
import com.forogh.opinionPoll.model.AnswerSheet;
import com.forogh.opinionPoll.service.AnswerSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answerSheet")
public class AnswerSheetController {
    @Autowired
    AnswerSheetService answerSheetService;

    @Autowired
    AnswerSheetMapper answerSheetMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AnswerSheetDTO> getById(@PathVariable Long id) {

        return ResponseEntity.ok(answerSheetMapper.toAnswerSheetDTO(answerSheetService.getById(id)));
    }
}
