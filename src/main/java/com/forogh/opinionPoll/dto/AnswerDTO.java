package com.forogh.opinionPoll.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AnswerDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = true)
    private Long questionId;

    @ApiModelProperty(required = false, hidden = false)
    private Long intValue;

    @ApiModelProperty(required = false, hidden = false)
    private String stringValue;

    @ApiModelProperty(required = false, hidden = false)
    private Double doubleValue;
    @ApiModelProperty(required = false, hidden = false)
    List <Long> answerOptionIds ;

    public List<Long> getAnswerOptionIds() {
        return answerOptionIds;
    }

    public void setAnswerOptionIds(List<Long> answerOptionIds) {
        this.answerOptionIds = answerOptionIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIntValue() {
        return intValue;
    }

    public void setIntValue(Long intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
