package com.forogh.opinionPoll.dto;

import com.forogh.opinionPoll.model.User;
import io.swagger.annotations.ApiModelProperty;

public class AnswerSheetDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
