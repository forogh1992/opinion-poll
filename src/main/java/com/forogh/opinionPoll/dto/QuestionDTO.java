package com.forogh.opinionPoll.dto;

import com.forogh.opinionPoll.model.QuestionType;
import io.swagger.annotations.ApiModelProperty;

public class QuestionDTO {


        @ApiModelProperty(required = false, hidden = true)
        private Long id;

        @ApiModelProperty(required = true)
        private String title;

        @ApiModelProperty(required = true)
        private QuestionType questionType;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }

        public void setQuestionType(QuestionType questionType) {
            this.questionType = questionType;
        }

}
